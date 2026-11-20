/*
 *  ¿PARA QUÉ SIRVE?
 *  Es para verificar que la persona correcta ingrese al programa
 *  dependiendo si su contraseña y usuario existen o estan bien escritos

 *  ¿CON QUIÉN SE CONECTA?
 *    UsuarioRepositorio y Usuario (verificarContrasena).
 *    VentanaLogin 
 */
package joyas_oscar.controlador;

import joyas_oscar.modelo.Usuario;
import joyas_oscar.repositorio.UsuarioRepositorio;


public class LoginControlador {

    private UsuarioRepositorio usuarios;     
    private Usuario usuarioActual;           

    public LoginControlador(UsuarioRepositorio usuarios) {
        this.usuarios = usuarios;
    }


    public String iniciarSesion(String nombreUsuario, String contrasena) {
        usuarioActual = null;                                                 
        if (nombreUsuario.trim().isEmpty() || contrasena.isEmpty()) {
            return "Escriba el usuario y la contraseña";                    
        }
        Usuario u = usuarios.buscarPorNombreUsuario(nombreUsuario.trim());
        if (u == null || !u.verificarContrasena(contrasena)) {
            return "Usuario o contraseña incorrectos";                        
        }
        if (!u.isActivo()) {
            return "El usuario está desactivado";                             
        }
        usuarioActual = u;                                                  
        return "Bienvenido, " + u.getNombreCompleto();
    }

    
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

  
    public void cerrarSesion() {
        usuarioActual = null;
    }
}
