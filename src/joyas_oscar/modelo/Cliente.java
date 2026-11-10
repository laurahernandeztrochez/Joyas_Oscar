
package joyas_oscar.modelo; // Paquete donde se encuentra la clase Cliente

/**
 * PREGUNTA 1: ¿Qué representa en la tienda?
 * Representa a quien se le ofrece los servicios del negocio joyas Oscar, los clientes
 */

public class Cliente { //Ya completo, sirve
   // Atributos todos en private
    private int idCliente;  //id PK en base de datos, no se ingresa manualmente gracias al auto_increment, identifica al cliente
    private String nombre;  //Tipo texto donde se registra el nombre del cliente
    private String apellido; //texto donde se registra el apellido del cliente
    private String telefono; //Tipo string porque int no es adecuado para registrar un numero de telefono (muy largo)
    private String direccion; //Tipo string porque una direccion contiene tanto texto como numeros
    private boolean activo;

    //Constructor, donde nace un objeto
    public Cliente(int idCliente, String nombre, String apellido, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activo = activo;
    }
    
    // GETTERS Y SETTERS 

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
      public boolean isActivo() {             
        return activo;
    }

    public void setActivo(boolean activo) { 
        this.activo = activo;
    }

    
    //Metodo tipo string para guardar nombre y apellido juntos como nombre completo
    public String getNombreCompleto() {
        return nombre + " "+ apellido;
    }
    
    //Metodo para validar que el telefono que se registre tenga minimo y maximo 10 digitos, de acuerdo a como son los numeros en COL
    public static boolean validarTelefono(String telefono){
     if (telefono ==null) return false; 
     return telefono.matches("\\d{10}"); //10 digitos
    }
    
    //Metodo donde si el telefono esta bien registrado, guarda el contacto, y si no el telefono  no es valido y no guarda datos
    public boolean registrarContacto(String direccion, String telefono) {
        if (validarTelefono(telefono)) { //Llama al metodo anterior
            this.direccion=direccion;
            this.telefono = telefono; // si es true, guarda direccion y telefono
            return true;
        } else {
            return false; //sino, telefono no valido no guarda datos
        }
    }
    
}

