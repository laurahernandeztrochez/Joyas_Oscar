
package joyas_oscar.modelo;


public class DetallePedido {
    private int idDetallePedido;
    private Pedido pedido;
    private Cliente cliente;
    private Joya joya;
    
    private double cantidad;
    private double precioUnitario;
    private double subtotal;
    private int stock;
    private String nombreJoya;
    
    public DetallePedido (int idDetallePedido, Pedido pedido, Cliente cliente, Joya joya, double cantidad, double precioUnitario, double subtotal, int stock, String nombreJoya) {
        this.idDetallePedido = idDetallePedido;
        this.pedido = pedido;
        this.cliente = cliente;
        this.joya = joya;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.stock = stock;
        this.nombreJoya = nombreJoya;
        
    }
    
    public int getIdDetallePedido() {
    return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }
    
       public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
  
      public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombreJoya() {
        return nombreJoya;
    }

    public void setNombreJoya(String nombreJoya) {
        this.nombreJoya = nombreJoya;
    }
            
}

