
package joyas_oscar.modelo;

import java.util.ArrayList; 
import java.util.List;


public class Pedido { //Completado, sirve
    
    private int idPedido;  //PK en bsd para identificar cada pedido con su id
    private Cliente cliente; //Referencia a la clase Cliente antes echa y completa
    private String estado; //Tipo string para registrar en que estado se encuentra el pedido (entregado, en proceso, pendiente, cancelado)
    private String direccion; //Registrar la direccion del pedido por si se hace a domicilio
    private double total; //en double, int es muy pequeño para registrar cantidades grandes de dinero
    private String fecha; //En base de datos, se usa DATE para la fecha, solo dejando registrar este tipo de fecha, no caracteres extraños
    private List<DetallePedido> detalles; //Se usa para el subtotal que se encuentra en el detalle pedido y con esos calcular el total
  
    
    //Constructor
    public Pedido(int idPedido, Cliente cliente,String estado, String direccion, String fecha) {
        this.idPedido  = idPedido;
        this.cliente = cliente;
        this.estado = estado;
        this.direccion = direccion;
        this.total = 0.0; //Empieza en 0
        this.fecha = fecha;
        this.detalles = new ArrayList<>();
    }
    
    //GETTERS Y SETTERS
    public int getIdPedido() {
    return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

      public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total=total;
    }
    
    public String getFecha() {
        return fecha;
    }
    public void setFecha (String fecha) {
        this.fecha=fecha;
    }
    
    public List<DetallePedido> getDetalles() {
        return detalles;
    }
    
   public void setDetalles(List<DetallePedido> detalles) {
       this.detalles = detalles;
   }
   
   
    //Metodo para validar el estado 
    public boolean validarEstado(String estado) {
        if (estado==null) return false; //No deja no llenar el estado
        String e = estado.toLowerCase().trim();
        return e.equals("Pendiente") || e.equals("En proceso") || e.equals("Entregado") || e.equals("Cancelado"); //Los diferentes posibles estados
    }
    //para validar this.estado
    public boolean validarEstado() {
        return validarEstado(this.estado);
    }
    //Metodo actualizarEstado
    public boolean actualizarEstado(String nuevoEstado){
        if (validarEstado(nuevoEstado)) {
            this.estado = nuevoEstado;
            return true;
        } else {
            return false;
        }
    }
    
    //Metodo validarDireccion donde no deja que este vacio
    public boolean validarDireccion () {
        if (this.direccion==null) {
            return false; //Si direccion esta vacio return false
        }
        String d = this.direccion.trim();
        return !d.isEmpty() && d.length() >5;
    }

    
    //Metodo calcularTotal con base a los subtotales del detalle pedido, que permita sacar el total
    public double calcularTotal() {
    double total = 0; //Empieza en 0
    for (DetallePedido detalle : this.detalles) {
        total = total + detalle.getSubTotal(); //Ecuacion paa calcular el total
       }
    this.total = total;
    return total; //Devuelve el resultado de esa ecuación
   }
    
    //Metodo registrarPedido
    public boolean registrarPedido(List<DetallePedido> listaDetalles) {
        if (validarDireccion() && validarEstado()) { //LLama a validar direccion y validar estado
              this.detalles = listaDetalles;
               calcularTotal();
               return true; //Si los dos son true, se registra el pedido
            
        }
        return false; //Sino, no se registra el pedido
    }
    
    //Metodo obtenerResumen para probar que los metodos esten bien
    public String obtenerResumen() {
        return  "Resumen: ID pedido: " + idPedido + 
           ", ID Cliente: " + cliente.getIdCliente() + 
           " (" + cliente.getNombreCompleto() + ")" +
           ", Direccion Envio: " + direccion + 
           ", Estado: " + estado + 
           ", Fecha pedido: " + fecha +
           ", total: " + total;
    }
           
        
    }

    
     

 
   

