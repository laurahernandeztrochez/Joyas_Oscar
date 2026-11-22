
/*
 * @author Juan / laura
 *
 */
package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import joyas_oscar.modelo.Joya;
import joyas_oscar.util.ConexionBD;

public class JoyaRepositorio {

    private static final String SELECT_BASE =
            "SELECT id_joya, nombre, material, precio, stock, activo FROM joyas ";

/*
 * =========================================================================
 * CREATE -> guardar
 * =========================================================================
 */
    public void guardar(Joya joya) {
        String sql = "INSERT INTO joyas (nombre, material, precio, stock, activo) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            llenarDatos(ps, joya);
            ps.executeUpdate();

            try (ResultSet llaves = ps.getGeneratedKeys()) {
                if (llaves.next()) {
                    joya.setIdJoya(llaves.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la joya: " + e.getMessage(), e);
        }
    }

/*
 * =========================================================================
 * LIST -> listar
 * =========================================================================
 */
    public ArrayList<Joya> listar() {
        ArrayList<Joya> lista = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE activo = TRUE ORDER BY id_joya";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(crearJoya(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar las joyas: " + e.getMessage(), e);
        }
        return lista;
    }

/*
 * =========================================================================
 * READ -> buscarPorId
 * =========================================================================
 */
    public Joya buscarPorId(int idJoya) {
        String sql = SELECT_BASE + "WHERE id_joya = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idJoya);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearJoya(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar la joya: " + e.getMessage(), e);
        }
        return null;
    }

/*
 * =========================================================================
 * SEARCH -> buscarPorNombre
 * =========================================================================
 */
    public ArrayList<Joya> buscarPorNombre(String nombre) {
        ArrayList<Joya> lista = new ArrayList<>();
        String sql = SELECT_BASE
                + "WHERE activo = TRUE AND nombre LIKE ? ORDER BY id_joya";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(crearJoya(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar las joyas: " + e.getMessage(), e);
        }
        return lista;
    }

/*
 * =========================================================================
 * UPDATE -> actualizar
 * =========================================================================
 */
    public boolean actualizar(Joya joya) {
        String sql = "UPDATE joyas SET nombre = ?, material = ?, precio = ?, "
                   + "stock = ?, activo = ? WHERE id_joya = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            llenarDatos(ps, joya);
            ps.setInt(6, joya.getIdJoya());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la joya: " + e.getMessage(), e);
        }
    }

/*
 * =========================================================================
 * DELETE -> desactivar
 * =========================================================================
 */
    public boolean desactivar(int idJoya) {
        String sql = "UPDATE joyas SET activo = FALSE WHERE id_joya = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idJoya);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al desactivar la joya: " + e.getMessage(), e);
        }
    }

    private Joya crearJoya(ResultSet rs) throws SQLException {
        Joya joya = new Joya(
                rs.getInt("id_joya"),
                rs.getString("nombre"),
                rs.getString("material"),
                rs.getDouble("precio"),
                rs.getInt("stock"),
                rs.getBoolean("activo"));
        return joya;
    }

    private void llenarDatos(PreparedStatement ps, Joya joya) throws SQLException {
        ps.setString(1, joya.getNombre());
        ps.setString(2, joya.getMaterial());
        ps.setDouble(3, joya.getPrecio());
        ps.setInt(4, joya.getStock());
        ps.setBoolean(5, joya.isActivo());
    }
}
