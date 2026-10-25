
package joyas_oscar.modelo;


public class Pago { //Falta
    
    private int idPago;
    private Pedido pedido;
    private double monto;
    private String estado;
    private String metodoPago;
    private String fechaPago;
    
    public Pago(int idPago, Pedido pedido, double monto, String metodoPago, String estado, String fechaPago) {
        this.idPago = idPago;
        this.pedido = pedido;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.fechaPago =  fechaPago;
       
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
    
    //Metodo validarPago
    public boolean validarPago(double monto){
        if (monto<=0) {
            return false;
        } if (pedido !=null && monto> pedido.calcularTotal()) {
            return false;
        } 
        return true;
    }

    
    
    //Metodo procesarPago
    public boolean procesarPago() {
        if (validarPago(monto)) {
            this.estado= "pagado";
            return true;
        }
        return false;
    }

    
    //Metodo generarComprobante
    public String generarComprobante() {
        System.out.println("Comprobante:");
        return "Id Pago: " +idPago +
                ", Pedido # " + pedido +
                ",Monto: " +monto +
                ",Metodo: " +metodoPago +
                ", Estado: " +estado +
                ", Fecha: " +fechaPago;
    }

}
