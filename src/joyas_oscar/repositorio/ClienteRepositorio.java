/*
 * =========================================================================
 *  CLASE: ClienteRepositorio              PAQUETE: joyas_oscar.repositorio
 *  VERSIÓN: MySQL
 * =========================================================================
 */
package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.util.ConexionBD;

/**
 * Accede a la tabla de clientes para registrar, consultar, actualizar
 * y desactivar clientes mediante la base de datos.
 */
public class ClienteRepositorio {

    // En SQL siempre va id_cliente
    private static final String SELECT_BASE =
            "SELECT id_cliente, nombre, apellido, telefono, direccion, activo FROM clientes ";

    public ClienteRepositorio() {
    }

    // =====================================================================
    // C: CREATE -> guardar
    // =====================================================================
    public void guardar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, apellido, telefono, direccion, activo) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            llenarDatos(ps, cliente);
            ps.executeUpdate();

            try (ResultSet llaves = ps.getGeneratedKeys()) {
                if (llaves.next()) {
                    cliente.setIdCliente(llaves.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el cliente: " + e.getMessage(), e);
        }
    }

    // =====================================================================
    // R: READ
    // =====================================================================
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE activo = TRUE ORDER BY id_cliente";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(crearCliente(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los clientes: " + e.getMessage(), e);
        }
        return lista;
    }

    public Cliente buscarPorId(int idCliente) {
        String sql = SELECT_BASE + "WHERE id_cliente = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el cliente: " + e.getMessage(), e);
        }
        return null;
    }

    public Cliente buscarPorNombre(String nombre) {
        String sql = SELECT_BASE + "WHERE nombre = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el cliente: " + e.getMessage(), e);
        }
        return null;
    }
        public Cliente buscarPorTelefono(String telefono) {
        String sql = SELECT_BASE + "WHERE telefono = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, telefono);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el cliente: " + e.getMessage(), e);
        }
        return null;
    }
    

    // =====================================================================
    // U: UPDATE
    // =====================================================================
    public boolean actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, direccion = ?, "
                   + "activo = ? WHERE id_cliente = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            llenarDatos(ps, cliente);
            ps.setInt(6, cliente.getIdCliente());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el cliente: " + e.getMessage(), e);
        }
    }

    // =====================================================================
    // D: DELETE -> desactivar
    // =====================================================================
    public boolean desactivar(int idCliente) {
        String sql = "UPDATE clientes SET activo = FALSE WHERE id_cliente = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al desactivar el cliente: " + e.getMessage(), e);
        }
    }

    // =====================================================================
    // MÉTODOS AYUDANTES
    // =====================================================================
    private Cliente crearCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente 
                (rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("telefono"),
                rs.getString("direccion"));
        
     
        c.setIdCliente(rs.getInt("id_cliente"));
        c.setActivo(rs.getBoolean("activo"));
        return c;
    }

    private void llenarDatos(PreparedStatement ps, Cliente c) throws SQLException {
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getTelefono());
        ps.setString(4, c.getDireccion());
        ps.setBoolean(5, c.isActivo());
    }
}