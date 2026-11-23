package joyas_oscar.controlador;

import java.util.ArrayList;
import joyas_oscar.modelo.Rol;
import joyas_oscar.modelo.Usuario;
import joyas_oscar.repositorio.UsuarioRepositorio;
import java.util.List;

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
  
    //Guardar
    public String guardarUsuario(String nombreCompleto, String nombreUsuario, String contrasenaHash, String rolTexto) {
        if (nombreUsuario.trim().isEmpty() || rolTexto.trim().isEmpty()) {
            return "El rol y el nombre son obligatorios";
        }
        if (usuarios.buscarPorNombreUsuario(nombreUsuario.trim()) != null) {
            return "Ya existe un usuario con ese nombre";
        }

        System.out.println("Rol que llega: "+ rolTexto + " ");
        String nombreRol = rolTexto.trim();
        int idRol = 1; // 1 = administrador
        if (nombreRol.equals("Vendedor")) {
            idRol = 2;
        } else if (nombreRol.equals("Joyero")) {
            idRol = 3;
        }
        Rol rol = new Rol(idRol, nombreRol);

       
        usuarios.guardar(new Usuario(nombreUsuario.trim(), contrasenaHash.trim(), nombreCompleto.trim(), rol));
        return "Usuario guardado";
    }

    //Actualizar
public String actualizarUsuario(int idUsuario, String nombreCompleto, String nombreUsuario, String contrasena, String confirmar) {
    Usuario u = usuarios.buscarPorId(idUsuario);
    if (u == null) {
        return "Seleccione un usuario de la tabla";
    }
    if (nombreUsuario.trim().isEmpty() || nombreCompleto.trim().isEmpty()) {
        return "El usuario y nombre completo son obligatorios";
    }
    if (!contrasena.equals(confirmar)) {
        return "Las contraseñas no coinciden";
    }

    Usuario otro = usuarios.buscarPorNombreUsuario(nombreUsuario.trim());
    if (otro != null && otro.getIdUsuario() != idUsuario) {
        return "Ya existe otro usuario con ese nombre";
    }

    
    String hashFinal = contrasena.trim().isEmpty() ? u.getContrasenaHash() : contrasena.trim();

  
    Usuario actualizado = new Usuario(
        u.getIdUsuario(),
        nombreUsuario.trim(),
        hashFinal,
        nombreCompleto.trim(),
        u.getRol(),
        u.isActivo()
    );

    usuarios.actualizar(actualizado);
    return "Usuario actualizado";
}
 
  //Eliminar
    public String desactivarUsuario(int idUsuario) {
        Usuario u = usuarios.buscarPorId(idUsuario);
        if (u == null) {
            return "Seleccione un usuario de la tabla";
        }
        usuarios.desactivar(idUsuario);
        return "Usuario eliminado";
    }
    
    public List<String> listarRoles() {
    return usuarios.listarRoles();
}
}