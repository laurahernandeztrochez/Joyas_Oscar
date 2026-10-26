
package joyas_oscar.modelo;


public class DetallePedido { //Completo, sirve
    private int idDetallePedido;
    private Joya joya;
    
    private double cantidad;
    private double precioUnitario;
    private double subtotal;
    
    public DetallePedido (int idDetallePedido,Joya joya, double cantidad) {
        this.idDetallePedido = idDetallePedido;
        this.joya = joya;
        this.cantidad = cantidad;
        this.precioUnitario = joya.getPrecio();
        this.subtotal = cantidad * precioUnitario;

        
    }
    
    public int getIdDetallePedido() {
    return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }
    
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
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
        this.subtotal = subtotal;
    }
    
    public Double getSubTotal() {
    return subtotal;
    }

    public void setSubTotal(Double subtotal) {
        this.subtotal = subtotal;
    }
  
    
    //Metodo para calular el subtotal
    public double calcularSubtotal() {
    this.subtotal = this.cantidad * this.precioUnitario;
    return subtotal;
    }
    
    //Metodo para validar la cantidad o stock
    public boolean validarCantidad(int cantidad) {
        return cantidad > 0 && cantidad <= this.joya.getStock();
    }
    
    //Metodo para registrar el detalle del pedido
    public boolean registrarDetalle(int cantidad) {
        double subtotal=  calcularSubtotal();
        if (validarCantidad(cantidad) && calcularSubtotal() >0) {
            this.cantidad = cantidad;
            this.precioUnitario= this.joya.getPrecio();
           this.subtotal = subtotal;
            return true;
        }
        return false;
    }
    
    public String obtenerResumen() {
        System.out.println("Detallle pedido: ");
        return "Joya: " + joya.getNombre() +
                ", cantidad: " + cantidad +
                ", precio: " + precioUnitario +
                ", subtotal: " + subtotal;
    }
    
    public String toString () {
        return obtenerResumen();
    }
    
            
}

