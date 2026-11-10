
package joyas_oscar.modelo; //Paquete donde se encuentra la clase pago


public class Pago { //Completo, sirve
    
    private int idPago; //Id que identifica todo el pago
    private Pedido pedido; //Referencia a pedido para saber cual se va a pagar
    private double monto; //Cuanto debe pagar/cuanto pago
    private String estado; //Pagado, cancelado, pendiente
    private String metodoPago; // transferencia, tarjeta, efectivo y nequi
    private String fechaPago; //Tipo string la fecha en que se registró el pago
    
    //Constructor
    public Pago(int idPago, Pedido pedido, double monto, String metodoPago, String estado, String fechaPago) {
        this.idPago = idPago;
        this.pedido = pedido;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.fechaPago =  fechaPago;
       
        //Getters y setters
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
    
    //Metodo que valida que el monto sea ni mas ni menos a lo que debia
    public boolean validarPago(double monto){
        if (monto<=0) { //que el monto sea mayor a 0 evitar que se deje vacio
            return false;
        } if (pedido !=null && monto> pedido.calcularTotal()) { //Que el monto sea igual al total del pedido registrado
            return false;
        } 
        return true;
    }

    
    
    //Metodo procesarPago
    public boolean procesarPago() {
        if (validarPago(monto)) { //Llama a validar pago, metodo anterior
            this.estado= "pagado"; 
            return true; //Si es true, se guarda el pago
        }
        return false;
    }

    
    //Metodo generarComprobante
    public String generarComprobante() { //Solo un resumen de todo el pago, comprobante
        System.out.println("Comprobante:");
        return "Id Pago: " +idPago +
                ", Pedido # " + pedido.getIdPedido() +
                ",Monto: " +monto +
                ",Metodo: " +metodoPago +
                ", Estado: " +estado +
                ", Fecha: " +fechaPago;
    }

}
