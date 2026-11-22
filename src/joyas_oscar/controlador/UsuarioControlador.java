package joyas_oscar.controlador;

import java.util.ArrayList;
import joyas_oscar.modelo.Rol;
import joyas_oscar.modelo.Usuario;
import joyas_oscar.repositorio.UsuarioRepositorio;

public class UsuarioControlador {

    private UsuarioRepositorio usuarios;

    public UsuarioControlador(UsuarioRepositorio usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> listaUsuario() {
        return usuarios.listar();
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        Usuario u = usuarios.buscarPorNombreUsuario(nombreUsuario.trim());
        if (u != null && u.isActivo()) {
            return u;
        }
        return null;
    }

    public String guardarUsuario(String nombreUsuario, String nombreCompleto, String contrasenaHash, String rolTexto) {
        if (nombreUsuario.trim().isEmpty() || rolTexto.trim().isEmpty()) {
            return "El rol y el nombre son obligatorios";
        }
        if (usuarios.buscarPorNombreUsuario(nombreUsuario.trim()) != null) {
            return "Ya existe un usuario con ese nombre";
        }

        String nombreRol = rolTexto.trim().toLowerCase();
        int idRol = 1; // 1 = administrador
        if (nombreRol.equals("joyero")) {
            idRol = 2;
        } else if (nombreRol.equals("vendedor")) {
            idRol = 3;
        }
        Rol rol = new Rol(idRol, nombreRol);

        // Orden correcto: nombre, contraseña, nombreCompleto, Rol
        usuarios.guardar(new Usuario(nombreUsuario.trim(), contrasenaHash.trim(), nombreCompleto.trim(), rol));
        return "Usuario guardado";
    }

    public String actualizarUsuario(int idUsuario, String nombreUsuario, String nombreCompleto) {
        Usuario u = usuarios.buscarPorId(idUsuario);
        if (u == null) {
            return "Seleccione un usuario de la tabla";
        }
        if (nombreUsuario.trim().isEmpty() || nombreCompleto.trim().isEmpty()) {
            return "El usuario y nombre completo son obligatorios";
        }

        Usuario otro = usuarios.buscarPorNombreUsuario(nombreUsuario.trim());
        if (otro != null && otro.getIdUsuario() != idUsuario) {
            return "Ya existe otro usuario con ese nombre";
        }

        u.setNombreUsuario(nombreUsuario.trim());
        u.setNombreCompleto(nombreCompleto.trim());
        usuarios.actualizar(u);
        return "Usuario actualizado";
    }

    public String desactivarUsuario(int idUsuario) {
        Usuario u = usuarios.buscarPorId(idUsuario);
        if (u == null) {
            return "Seleccione un usuario de la tabla";
        }
        usuarios.desactivar(idUsuario);
        return "Usuario eliminado";
    }
}