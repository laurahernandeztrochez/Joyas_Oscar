
package joyas_oscar.modelo;


public class DetallePedido { //Completo, sirve
    //referencia a pedido y joya
    private Pedido pedido;
    private Joya joya;
    
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    //Constructor: crea el detalle con su pedido y joya
    public DetallePedido (Pedido pedido, Joya joya, int cantidad) {
        this.pedido = pedido;
        this.joya = joya;
        this.cantidad = cantidad;
        this.precioUnitario = joya.getPrecio();
        this.subtotal = cantidad * precioUnitario;

        
    }
    
    //Getters y setters
    public Pedido getPedido() {
    return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
       public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
    }
    
    public Double getPrecioUnitario() {
    return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitariol) {
        this.precioUnitario = precioUnitario;
    }
    
    public Double getSubTotal() {
    return subtotal;
    }

    public void setSubTotal(Double subtotal) {
        this.subtotal = subtotal;
    }
  
    
    //Metodo para calular el subtotal
    public double calcularSubtotal() {
    this.subtotal = this.cantidad * this.precioUnitario; //Ecuacion para calcular el subtotal
    return subtotal; //lo calcula y guarda
    }
    
    //Metodo para validar la cantidad o stock
    public boolean validarCantidad(int cantidad) {
        return cantidad > 0 && cantidad <= this.joya.getStock();
    }
    
    //Metodo para registrar el detalle del pedido
    public boolean registrarDetalle(int cantidad) {
        double subtotal=  calcularSubtotal();
        if (validarCantidad(cantidad) && calcularSubtotal() >0) { //llama a validar cantidad y calcular el subtotal
            this.cantidad = cantidad;
            this.precioUnitario= this.joya.getPrecio();
           this.subtotal = subtotal; 
            return true; //Si los dos son true, lo guarda
        }
        return false; //sino, no guarda nada
    }
    
    //Resumen para el detalle del pedido
    public String obtenerResumen() {
        System.out.println("Detallle pedido: ");
        return "Joya: " + joya.getNombre() +
                ", cantidad: " + cantidad +
                ", precio: " + precioUnitario +
                ", subtotal: " + subtotal;
    }
   
         
}

