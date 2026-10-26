
package joyas_oscar.modelo;


public class Cliente { //Ya completo, sirve
   // Atributos
    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public Cliente(int idCliente, String nombre, String apellido, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

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
    
    //Metodo obtenerNombreCompleto
    public String getNombreCompleto() {
        return nombre + " "+ apellido;
    }
    //Metodo validarTelefono
    public static boolean validarTelefono(String telefono){
     if (telefono ==null) return false;
     return telefono.matches("\\d{10}");
    }
    //Metodo registrarContacto
    public boolean registrarContacto(String direccion, String telefono) {
        if (validarTelefono(telefono)) {
            this.direccion=direccion;
            telefono=telefono;
            return true;
        } else {
            System.out.println("Telefono no valido: "+telefono);
            return false;
        }
    }
    public String toString () {
        String telTexto= validarTelefono(telefono) ? telefono : "no valido";
        return "id: " + idCliente + ", nombre completo: "+ getNombreCompleto()+ ", telefono: " +telTexto + ", direccion: "+ direccion;
    }
}

