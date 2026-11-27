package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import joyas_oscar.modelo.Pago;
import joyas_oscar.util.ConexionBD;
import joyas_oscar.repositorio.PedidoRepositorio;
import joyas_oscar.modelo.Pedido;

public class PagoRepositorio {

    private static final String SELECT_BASE =
            "SELECT id_pago, fecha_pago, estado, metodo_pago, monto, id_pedido FROM pagos ";
       private final PedidoRepositorio pedidoRepo = new PedidoRepositorio();
    

    /*
     * CREATE -> guardar
     * Botón Guardar de tu Ventana Pago.
     */
    public void guardar(Pago pago) {
        String sql = "INSERT INTO pagos "
                   + "(fecha_pago, estado, metodo_pago, monto, id_pedido) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            llenarDatos(ps, pago);
            ps.executeUpdate();

            try (ResultSet llaves = ps.getGeneratedKeys()) {
                if (llaves.next()) {
                    pago.setIdPago(llaves.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el pago: " + e.getMessage(), e);
        }
    }

    /*
     * LIST -> listar
     * Carga tu tabla Historial de pagos.
     */
    public ArrayList<Pago> listar() {
        ArrayList<Pago> lista = new ArrayList<>();
        String sql = SELECT_BASE + "ORDER BY id_pago";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(crearPago(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los pagos: " + e.getMessage(), e);
        }
        return lista;
    }

    /*
     * READ -> buscarPorId
     */
    public Pago buscarPorId(int idPago) {
        String sql = SELECT_BASE + "WHERE id_pago = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPago);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearPago(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el pago: " + e.getMessage(), e);
        }
        return null;
    }
    
    /*
 * SEARCH -> buscarPorNombreCliente
 * Buscador del Historial de pagos por nombre del cliente.
 * Ej: escribes "Laura" y te trae todos sus pagos.
 */
public ArrayList<Pago> buscarPorNombreCliente(String nombre) {
    ArrayList<Pago> lista = new ArrayList<>();
    // OJO: Aquí hacemos JOIN para traer el nombre del cliente
    String sql = "SELECT p.id_pago, p.fecha_pago, p.estado, p.metodo_pago, p.monto, p.id_pedido "
               + "FROM pagos p "
               + "JOIN pedidos ped ON p.id_pedido = ped.id_pedido "
               + "JOIN clientes c ON ped.id_cliente = c.id_cliente "
               + "WHERE c.nombre LIKE ? ORDER BY p.id_pago";

    try (Connection con = ConexionBD.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, "%" + nombre + "%");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(crearPago(rs));
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al buscar pagos por cliente: " + e.getMessage(), e);
    }
    return lista;
}

    /*
     * UPDATE -> actualizar
     * Botón Editar de Ventana Pago.
     */
    public boolean actualizar(Pago pago) {
        String sql = "UPDATE pagos SET fecha_pago = ?, estado = ?, metodo_pago = ?, "
                   + "monto = ?, id_pedido = ? WHERE id_pago = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            llenarDatos(ps, pago);
            ps.setInt(6, pago.getIdPago());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el pago: " + e.getMessage(), e);
        }
    }

    /*
     * DELETE -> eliminar
     * En Material era "desactivar" porque tenía activo.
     * En Pago como NO tiene activo, se hace DELETE de verdad.
     */
    public boolean eliminar(int idPago) {
        String sql = "DELETE FROM pagos WHERE id_pago = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPago);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el pago: " + e.getMessage(), e);
        }
    }

    // --- ESTOS DOS SON LOS IMPORTANTES ---

private Pago crearPago(ResultSet rs) throws SQLException {
    Pedido pedido = pedidoRepo.buscarPorId(rs.getInt("id_pedido"));

    return new Pago(
            rs.getInt("id_pago"),                    // 1. id
            pedido,                                 // 2. Pedido
            rs.getDouble("monto"),                  // 3. monto -> ¡este es el double que te pedía!
            rs.getString("metodo_pago"),             // 4. metodoPago
            rs.getString("estado"),                 // 5. estado
            rs.getDate("fecha_pago").toString());    // 6. fecha al final
}
    private void llenarDatos(PreparedStatement ps, Pago pago) throws SQLException {
        ps.setDate(1, Date.valueOf(pago.getFechaPago()));
        ps.setString(2, pago.getEstado());
        ps.setString(3, pago.getMetodoPago());
        ps.setDouble(4, pago.getMonto());
       ps.setInt(5, pago.getPedido().getIdPedido());
    }
}