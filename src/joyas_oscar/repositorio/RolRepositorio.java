package joyas_oscar.repositorio;

import joyas_oscar.modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import joyas_oscar.util.ConexionBD;

/**
 * Consulta los roles disponibles en la base de datos, ya sea para listarlos
 * o para buscar uno por su nombre.
 */
public class RolRepositorio {

    // Trae todos los roles de la BD para llenar el combo
    public List<Rol> listarRoles() {
        List<Rol> roles = new ArrayList<>();
        String sql = "SELECT id_rol, nombre FROM roles";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Rol r = new Rol(rs.getInt("id_rol"), rs.getString("nombre"));
                roles.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    // Busca un rol por su nombre, para cuando guardas
    public Rol buscarPorNombre(String nombre) {
        String sql = "SELECT id_rol, nombre FROM roles WHERE nombre = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Rol(rs.getInt("id_rol"), rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}