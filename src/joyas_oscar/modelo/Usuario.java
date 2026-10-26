
package joyas_oscar.modelo;


public class Usuario {
    
    private int idUsuario; 
    private Rol rol;
    
    private String nombreUsuario;
    private String contrasena;
    private boolean activo;
    private String nombreCompleto;
    
    public Usuario(int idUsuario, Rol rol, String nombreUsuario, String contrasena, boolean activo, String nombreCompleto) {
     this.idUsuario = idUsuario;
     this.rol = rol;
     this.nombreUsuario = nombreUsuario;
     this.contrasena = contrasena;
     this.activo = activo;
     this.nombreCompleto = nombreCompleto;
    
    } //Cierra constructor
    
      public int getIdUsuario() {
    return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
      public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
     
    public String getContrasena() {
    return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public Boolean getActivo() {
    return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    //Metodo para..
}
