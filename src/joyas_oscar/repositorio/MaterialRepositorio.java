package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import joyas_oscar.modelo.Material;
import joyas_oscar.util.ConexionBD;

/**
 * Accede a la base de datos para registrar, listar, buscar, actualizar
 * y desactivar materiales.
 */
public class MaterialRepositorio {

    private static final String SELECT_BASE =
            "SELECT id_material, tipo_material, stock, nombre, peso, precio, activo "
          + "FROM materiales ";

    public void guardar(Material material) {
        String sql = "INSERT INTO materiales "
                   + "(tipo_material, stock, nombre, peso, precio, activo) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            llenarDatos(ps, material);
            ps.executeUpdate();

            try (ResultSet llaves = ps.getGeneratedKeys()) {
                if (llaves.next()) {
                    material.setIdMaterial(llaves.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el material: " + e.getMessage(), e);
        }
    }

    public ArrayList<Material> listar() {
        ArrayList<Material> lista = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE activo = TRUE ORDER BY id_material";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(crearMaterial(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los materiales: " + e.getMessage(), e);
        }
        return lista;
    }

    public Material buscarPorId(int idMaterial) {
        String sql = SELECT_BASE + "WHERE id_material = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMaterial);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearMaterial(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el material: " + e.getMessage(), e);
        }
        return null;
    }

    public ArrayList<Material> buscarPorNombre(String nombre) {
        ArrayList<Material> lista = new ArrayList<>();
        String sql = SELECT_BASE
                   + "WHERE activo = TRUE AND nombre LIKE ? ORDER BY id_material";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(crearMaterial(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar los materiales: " + e.getMessage(), e);
        }
        return lista;
    }

    public boolean actualizar(Material material) {
        String sql = "UPDATE materiales SET tipo_material = ?, stock = ?, nombre = ?, "
                   + "peso = ?, precio = ?, activo = ? WHERE id_material = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            llenarDatos(ps, material);
            ps.setInt(7, material.getIdMaterial());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el material: " + e.getMessage(), e);
        }
    }

    public boolean desactivar(int idMaterial) {
        String sql = "UPDATE materiales SET activo = FALSE WHERE id_material = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMaterial);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al desactivar el material: " + e.getMessage(), e);
        }
    }

    private Material crearMaterial(ResultSet rs) throws SQLException {
        return new Material(
                rs.getInt("id_material"),
                rs.getDouble("peso"),
                rs.getInt("stock"),
                rs.getString("nombre"),
                rs.getString("tipo_material"),
                rs.getDouble("precio"),
                rs.getBoolean("activo"));
    }

    private void llenarDatos(PreparedStatement ps, Material material) throws SQLException {
        ps.setString(1, material.getTipoMaterial());
        ps.setInt(2, material.getStock());
        ps.setString(3, material.getNombre());
        ps.setDouble(4, material.getPeso());
        ps.setDouble(5, material.getPrecio());
        ps.setBoolean(6, material.isActivo());
    }
}
