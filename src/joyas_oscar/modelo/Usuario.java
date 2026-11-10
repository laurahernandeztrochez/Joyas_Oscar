

/*
Clase Usuario
*¿Para que sirve?
sirve para identificar la persona que entra dentro de la bsd y las ventanas
para poder iniciar sesion de manera efectiva y segura
*Se conecta con: Rol (previamente creado) y con seguridad (tambien previamente creado
*/

package joyas_oscar.modelo; //Paquete donde se encuentra la clase Usuario

import joyas_oscar.util.Seguridad; //importar la seguridad que esta en el paquete util, antes creada

public class Usuario {
    
    private int idUsuario; //Identifica a un usuario con su id unico
    private Rol rol; //Referencia al rol
    
    private String nombreUsuario; //El nombre con el que se inicia ej: oscar
    private String contrasena; //La constraseña que el usuario asigne para poder ingresar a su cuenta
    private boolean activo; // Para saber si el usuario esta o no activo, no borrarlo porque ahi dentro tiene sus registros
    private String nombreCompleto; //Nombre completo del usuario ej: Oscar Toro Lopez
    
    //Constructor
    public Usuario(int idUsuario, Rol rol, String nombreUsuario, String contrasena, boolean activo, String nombreCompleto) {
     this.idUsuario = idUsuario;
     this.rol = rol;
     this.nombreUsuario = "sinusuario";                         
     setNombreUsuario(nombreUsuario);   
     this.contrasena = Seguridad.hashSHA256(contrasena); 
     this.activo = true;
    this.nombreCompleto = "Sin nombre";                        
    setNombreCompleto(nombreCompleto);                       

    
    } //Cierra constructor
        
       //Evita que se deje espacio en blanco, se acepta si no esta vacio
        public void setNombreUsuario(String nombreUsuario) {
        if (!nombreUsuario.equals("")) {        
            this.nombreUsuario = nombreUsuario;  
        }
    }
        
        //Evita que se dejen espacios en blanco, si no esta vacio, se guarda
        public void setNombreCompleto(String nombreCompleto) { 
        if (!nombreCompleto.equals("")) {         
            this.nombreCompleto = nombreCompleto; 
        }
    }

    
    
    //Getter y setters
      public int getIdUsuario() {
    return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
      public Rol getRol() {
        return rol;
    }
      
    public String getNombreUsuario() {
        return nombreUsuario;
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
   
       
    public String getContrasenaHash() {      
        return contrasena;                  
    }

    //No existe: setRol, getContrasena ni setContrasenaHash():
    
    //Metodo que verifica si la contraseña es correcta comparandose entre si
        public boolean verificarContrasena(String contrasena) {
        String hash = Seguridad.hashSHA256(contrasena);   
        return hash.equals(contrasena);               
    }
        
      // Metodo para verificar si el usuario es administrador, dependiendo de su rol se muestran o no ciertas opciones en las ventanas
    public boolean esAdministrador() {
        return rol.getNombre().equals("Administrador"); //Verifica que el nombre sea igual a "Administrador"
    }
    
  
    //Metodo para guardar en texto Oscar Toro (Administrador)
    public String obtenerInformacion() {
        return nombreCompleto + " (" + rol.getNombre() + ")";
    }


}
