/*
 * =========================================================================
 *  CLASE: PedidoRepositorio              PAQUETE: joyas_oscar.repositorio
 *  VERSIÓN: MySQL
 * =========================================================================
 */
package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.modelo.DetallePedido;
import joyas_oscar.modelo.Joya;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.util.ConexionBD;

public class PedidoRepositorio {

    private static final String SELECT_BASE =
            "SELECT id_pedido, estado, direccion, fecha_pedido, total, id_cliente FROM pedidos ";

    private final ClienteRepositorio clienteRepo = new ClienteRepositorio();
    private final JoyaRepositorio joyaRepo = new JoyaRepositorio();

    public PedidoRepositorio() {
    }

    // =====================================================================
    // C: CREATE -> guardar 
    // =====================================================================
    public void guardar(Pedido pedido) {
        List<DetallePedido> detalles = pedido.getDetalles();
        if (detalles == null || detalles.isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos una joya.");
        }

        String sqlPedido = "INSERT INTO pedidos (estado, direccion, fecha_pedido, total, id_cliente) "
                         + "VALUES (?, ?, ?, ?, ?)";
        
        String sqlDetalle = "INSERT INTO detalle_pedidos (id_joya, id_pedido, precio_unitario, subtotal, cantidad) "
                          + "VALUES (?, ?, ?, ?, ?)";
        // El "AND stock >= ?" evita vender más de lo que hay
        String sqlStock = "UPDATE joyas SET stock = stock - ? WHERE id_joya = ? AND stock >= ?";

        pedido.calcularTotal(); // suma los subtotales de los detalles

        try (Connection con = ConexionBD.obtenerConexion()) {
            con.setAutoCommit(false); // inicia la transacción
            try {
                // 1. Guardar la cabecera
                try (PreparedStatement ps = con.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                    llenarDatos(ps, pedido);
                    ps.executeUpdate();

                    try (ResultSet llaves = ps.getGeneratedKeys()) {
                        if (llaves.next()) {
                            pedido.setIdPedido(llaves.getInt(1));
                        }
                    }
                }

                // 2. Guardar cada detalle y descontar el stock
                try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);
                     PreparedStatement psStock = con.prepareStatement(sqlStock)) {

                    for (DetallePedido d : detalles) {
                        int cantidad = d.getCantidad(); 

                        // Orden EXACTO del SQL: id_joya, id_pedido, precio_unitario, subtotal, cantidad
                        psDetalle.setInt(1, d.getJoya().getIdJoya());
                        psDetalle.setInt(2, pedido.getIdPedido());
                        psDetalle.setDouble(3, d.getPrecioUnitario());
                        psDetalle.setDouble(4, d.calcularSubtotal());
                        psDetalle.setInt(5, cantidad);
                        psDetalle.executeUpdate();

                        psStock.setInt(1, cantidad);
                        psStock.setInt(2, d.getJoya().getIdJoya());
                        psStock.setInt(3, cantidad);
                        if (psStock.executeUpdate() == 0) {
                            throw new SQLException("Stock insuficiente para la joya "
                                    + d.getJoya().getNombre());
                        }
                    }
                }

                con.commit(); // todo salió bien
            } catch (SQLException | RuntimeException e) {
                con.rollback(); // algo falló: no queda nada a medias
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el pedido: " + e.getMessage(), e);
        }
    }

    // =====================================================================
    // R: READ
    // =====================================================================
    public ArrayList<Pedido> listar() {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = SELECT_BASE + "ORDER BY id_pedido";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(crearPedido(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los pedidos: " + e.getMessage(), e);
        }
        return lista;
    }

    // Este sí trae también los detalles del pedido
    public Pedido buscarPorId(int idPedido) {
        String sql = SELECT_BASE + "WHERE id_pedido = ?";
        Pedido pedido = null;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPedido);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pedido = crearPedido(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el pedido: " + e.getMessage(), e);
        }

        if (pedido != null) {
            pedido.setDetalles(listarDetalle(pedido));
        }
        return pedido;
    }

    public ArrayList<Pedido> buscarPorCliente(String nombre) {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE nombre = ? ORDER BY id_pedido";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(crearPedido(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar los pedidos del cliente: " + e.getMessage(), e);
        }
        return lista;
    }

    public ArrayList<Pedido> listarPorEstado(String estado) {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE estado = ? ORDER BY id_pedido";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estado);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(crearPedido(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los pedidos por estado: " + e.getMessage(), e);
        }
        return lista;
    }

    // Las joyas (líneas) de un pedido
    public ArrayList<DetallePedido> listarDetalle(Pedido pedido) {
        ArrayList<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT id_joya, cantidad, precio_unitario FROM detalle_pedidos WHERE id_pedido = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pedido.getIdPedido());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Joya joya = joyaRepo.buscarPorId(rs.getInt("id_joya"));
                    DetallePedido d = new DetallePedido(pedido, joya, rs.getInt("cantidad"));

                    // El constructor toma el precio ACTUAL de la joya;
                    // aquí se restaura el precio que tenía cuando se hizo el pedido.
                    d.setPrecioUnitario(rs.getDouble("precio_unitario"));
                    d.calcularSubtotal();
                    lista.add(d);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar el detalle del pedido: " + e.getMessage(), e);
        }
        return lista;
    }

    // =====================================================================
    // U: UPDATE -> solo estado y dirección (el total y las joyas quedan fijos)
    // =====================================================================
    public boolean actualizar(Pedido pedido) {
        String sql = "UPDATE pedidos SET estado = ?, direccion = ? WHERE id_pedido = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pedido.getEstado());
            ps.setString(2, pedido.getDireccion());
            ps.setInt(3, pedido.getIdPedido());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el pedido: " + e.getMessage(), e);
        }
    }

    public boolean actualizarEstado(int idPedido, String nuevoEstado) {
        String sql = "UPDATE pedidos SET estado = ? WHERE id_pedido = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el estado del pedido: " + e.getMessage(), e);
        }
    }

    // =====================================================================
    // D: DELETE -> cancelar (estado "cancelado" + devuelve el stock)
    // =====================================================================
    public boolean cancelar(int idPedido) {
        String sqlEstado = "SELECT estado FROM pedidos WHERE id_pedido = ? FOR UPDATE";
        String sqlStock = "UPDATE joyas j JOIN detalle_pedidos d ON j.id_joya = d.id_joya "
                        + "SET j.stock = j.stock + d.cantidad WHERE d.id_pedido = ?";
        String sqlCancelar = "UPDATE pedidos SET estado = 'cancelado' WHERE id_pedido = ?";

        try (Connection con = ConexionBD.obtenerConexion()) {
            con.setAutoCommit(false);
            try {
                String estado = null;
                try (PreparedStatement ps = con.prepareStatement(sqlEstado)) {
                    ps.setInt(1, idPedido);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            estado = rs.getString("estado");
                        }
                    }
                }

                if (estado == null) {
                    return false; // el pedido no existe
                }
                if (estado.trim().equalsIgnoreCase("cancelado")) {
                    throw new SQLException("El pedido ya está cancelado.");
                }

                try (PreparedStatement ps = con.prepareStatement(sqlStock)) {
                    ps.setInt(1, idPedido);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = con.prepareStatement(sqlCancelar)) {
                    ps.setInt(1, idPedido);
                    ps.executeUpdate();
                }

                con.commit();
                return true;
            } catch (SQLException | RuntimeException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cancelar el pedido: " + e.getMessage(), e);
        }
    }

    // =====================================================================
    // MÉTODOS AYUDANTES
    // =====================================================================
    private Pedido crearPedido(ResultSet rs) throws SQLException {
        Cliente cliente = clienteRepo.buscarPorId(rs.getInt("id_cliente"));

        Pedido p = new Pedido(
                rs.getInt("id_pedido"),
                cliente,
                rs.getString("estado"),
                rs.getString("direccion"),
                rs.getDate("fecha_pedido").toString()); // yyyy-MM-dd

        p.setTotal(rs.getDouble("total"));
        return p;
    }

    // Orden del INSERT: estado, direccion, fecha_pedido, total, id_cliente
    private void llenarDatos(PreparedStatement ps, Pedido p) throws SQLException {
        ps.setString(1, p.getEstado());
        ps.setString(2, p.getDireccion());
        ps.setDate(3, Date.valueOf(p.getFecha())); // String yyyy-MM-dd -> DATE
        ps.setDouble(4, p.getTotal());
        ps.setInt(5, p.getCliente().getIdCliente());
    }
}