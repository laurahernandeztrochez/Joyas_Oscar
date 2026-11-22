

/*
Clase Usuario
*¿Para que sirve?
sirve para identificar la persona que entra dentro de la bsd y las ventanas
para poder iniciar sesion de manera efectiva y segura
*Se conecta con: Rol (previamente creado) y con seguridad (tambien previamente creado
*/

package joyas_oscar.modelo; //Paquete donde se encuentra la clase Usuario

import joyas_oscar.util.Seguridad;  //importar la seguridad que esta en el paquete util, antes creada

public class Usuario {

    private int idUsuario; //Identifica a un usuario con su id unico
    private Rol rol; //Referencia al rol
    
    private String nombreUsuario; //El nombre con el que se inicia ej: oscar
    private String contrasenaHash; //La constraseña que el usuario asigne para poder ingresar a su cuenta
    private boolean activo; // Para saber si el usuario esta o no activo, no borrarlo porque ahi dentro tiene sus registros
    private String nombreCompleto; //Nombre completo del usuario ej: Oscar Toro Lopez
       

    //Constructor
    public Usuario(String nombreUsuario, String contrasena, String nombreCompleto, Rol rol) {
        this.nombreUsuario = "sinusuario";                   
        setNombreUsuario(nombreUsuario);                           
        this.contrasenaHash = Seguridad.hashSHA256(contrasena);   
        this.nombreCompleto = "Sin nombre";                        
        setNombreCompleto(nombreCompleto);                 
        this.rol = rol;                                          
        this.activo = true;                                      
                                                                 
    }
 
    //Segundo constructor para MySQL, solo lo usa el repositorio de usuario
   
    public Usuario(int idUsuario, String nombreUsuario, String contrasenaHash,
        String nombreCompleto, Rol rol, boolean activo) {
        this.idUsuario = idUsuario;                            
        this.nombreUsuario = nombreUsuario;
        this.contrasenaHash = contrasenaHash;    
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;            
        this.activo = activo;
    }
    
    //Metodos

    
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

    
     //Metodo que verifica si la contraseña es correcta comparando con el equals
    public boolean verificarContrasena(String contrasena) {
        String hash = Seguridad.hashSHA256(contrasena);  
        return hash.equals(contrasenaHash);               
    }

     // Metodo para verificar si el usuario es administrador, dependiendo de 
     //su rol se muestran o no ciertas opciones en las ventanas
    public boolean esAdministrador() {
        return rol.getNombre().equals("Administrador");   
    }

      //Metodo para guardar en texto por ejemplo: Oscar Toro 
    public String obtenerInformacion() {
        return nombreCompleto + " (" + rol.getNombre() + ")";
    }

    //Getter y setters
    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {                 
        this.idUsuario = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isActivo() {               
        return activo;
    }

    public void setActivo(boolean activo) {    
        this.activo = activo;
    }

    public String getContrasenaHash() {        
        return contrasenaHash;                  
    }

     //No existe: setRol, getContrasena ni setContrasenaHash() a proposito
     // para que no se pueda editar ni el rol (hay 3 fijos), getcontrasena que la contraseña no se guarde como tal
    // y el setcontrasena para que no se cambia la huella y que no reconzoca la contraseña
  
}