
package joyas_oscar.modelo;


public class Pago {
    
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

    
}
