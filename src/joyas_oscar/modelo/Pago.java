
package joyas_oscar.modelo;


public class Pago { //Falta
    
    private int idPago;
    private Pedido pedido;
    private double monto;
    private String estado;
    private String metodoPago;
    private String fechaPago;
    private String comprobante;
    
    public Pago(int idPago, Pedido pedido, double monto, String estado, String metodoPago, String fechaPago, String comprobante) {
        this.idPago = idPago;
        this.pedido = pedido;
        this.monto = monto;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.fechaPago =  fechaPago;
        this.comprobante = comprobante;
    }
    
    public int getIdPago() {
    return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public double getMonto() {
    return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getMetodoPago() {
    return metodoPago;
    }
    
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFechaPago() {
    return fechaPago;
    }
    
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public String getComprobante() {
    return comprobante;
    }
    
    public void setComprobante(String combrobante) {
        this.comprobante = comprobante;
    }

    //Metodo validarPago
    public boolean validarPago(double monto){
        
    }
    
    //Metodo procesarPago
    public boolean procesarPago() {
        if (validarPago(monto)) {
            return true;
        }
    }
    
    //Metodo generarPago
    public String generarPago() {
        return
    }
    
}
