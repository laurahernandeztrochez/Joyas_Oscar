/*
 *  ¿PARA QUÉ SIRVE?
 *    es donde permite hacer consultas y funcionar los botones de guardar,
 *   actualizar, y desactivar, además poder buscar un usuario por su id
 *    
 *  ¿CON QUIÉN SE CONECTA?
 *    Usa:
 *      - ConexionBD    
 *      - Usuario y Rol 
 *      - LoginControlador → y, a través de él, VentanaLogin.
 *
 *  ¿QUÉ DEBE EXISTIR ANTES DE CREAR ESTA CLASE?
 *    - El SEGUNDO constructor de Usuario (el que recibe el hash).
 *    - Las tablas echas en MySQL (nuestro caos 8 tablas) con sus insert
 *
 */
package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import joyas_oscar.modelo.Rol;
import joyas_oscar.modelo.Usuario;
import joyas_oscar.util.ConexionBD;

public class UsuarioRepositorio {

    private static final String SELECT_BASE =
            "SELECT u.id_usuario, u.nombre_usuario, u.contrasena_hash, u.nombre_completo, u.activo, "
          + "r.id_rol AS id_rol, r.nombre AS rol_nombre "
          + "FROM usuarios u "
          + "JOIN roles r ON r.id_rol = u.id_rol ";

    public UsuarioRepositorio() {
    }

 
    // donde lista solo los usuarios que eten activos (TRUE)
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = SELECT_BASE + "WHERE u.activo = TRUE ORDER BY u.id_usuario";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {                              
                lista.add(crearUsuario(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los usuarios: " + e.getMessage(), e);
        }
        return lista;
    }

    // Si al buscar por id, el id no existe da error:
    public Usuario buscarPorId(int id) {
        String sql = SELECT_BASE + "WHERE u.id_usuario = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario: " + e.getMessage(), e);
        }
        return null;
    }

    // Busca el nombre, si no existe no se devuelve el nombre del usuario
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        String sql = SELECT_BASE + "WHERE u.nombre_usuario = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return crearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario: " + e.getMessage(), e);
        }
        return null;
    }

   
    private Usuario crearUsuario(ResultSet rs) throws SQLException {
        Rol rol = new Rol(rs.getInt("id_rol"), rs.getString("rol_nombre"));
        return new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"),
                rs.getString("contrasena_hash"), rs.getString("nombre_completo"),
                rol, rs.getBoolean("activo"));
    }
    
        // Guardar - usa el id_rol de la tabla roles
    public void guardar(Usuario u) {
        String sql = "INSERT INTO usuarios (nombre_usuario, contrasena_hash, nombre_completo, id_rol, activo) VALUES (?, ?, ?, ?, TRUE)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getContrasenaHash());
            ps.setString(3, u.getNombreCompleto());
            ps.setInt(4, u.getRol().getIdRol());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el usuario: " + e.getMessage(), e);
        }
    }

    // Actualizar - solo nombre de usuario y nombre completo
    public void actualizar(Usuario u) {
        String sql = "UPDATE usuarios SET nombre_usuario = ?, nombre_completo = ? WHERE id_usuario = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getNombreCompleto());
            ps.setInt(3, u.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el usuario: " + e.getMessage(), e);
        }
    }

    // Desactivar - no borra, solo pone activo en FALSE
    public void desactivar(int id) {
        String sql = "UPDATE usuarios SET activo = FALSE WHERE id_usuario = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al desactivar el usuario: " + e.getMessage(), e);
        }
    }
    
   public List<String> listarRoles() {
    List<String> roles = new ArrayList<>();
    String sql = "SELECT nombre FROM roles ORDER BY nombre";
    try (Connection con = ConexionBD.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            roles.add(rs.getString("nombre"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return roles;
}
   
}