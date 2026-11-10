
package joyas_oscar.modelo;

public class DetallePedido {
    // Atributos
    private int idDetallePedido;
    private Pedido pedido;
    private Joya joya;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    // Constructor principal
    public DetallePedido(int idDetallePedido, Joya joya, int cantidad) {
        this.idDetallePedido = idDetallePedido;
        this.joya = joya;
        this.cantidad = cantidad;
        this.precioUnitario = (joya != null) ? joya.getPrecio() : 0;
        this.subtotal = this.cantidad * this.precioUnitario;
    }

    // Constructor alternativo con pedido
    public DetallePedido(Pedido pedido, Joya joya, int cantidad) {
        this.pedido = pedido;
        this.joya = joya;
        this.cantidad = cantidad;
        this.precioUnitario = (joya != null) ? joya.getPrecio() : 0;
        this.subtotal = this.cantidad * this.precioUnitario;
    }

    // Getters y setters
    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
        if (this.joya != null) {
            this.precioUnitario = this.joya.getPrecio();
        }
        this.subtotal = calcularSubtotal();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.subtotal = calcularSubtotal();
    }

    public double getSubTotal() {
        return subtotal;
    }

    public void setSubTotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // Metodo para calcular el subtotal
    public double calcularSubtotal() {
        if (this.joya != null) {
            this.precioUnitario = this.joya.getPrecio();
        }
        this.subtotal = this.cantidad * this.precioUnitario;
        return subtotal;
    }

    // Metodo para validar la cantidad o stock
    public boolean validarCantidad(int cantidad) {
        return cantidad > 0 && this.joya != null && cantidad <= this.joya.getStock();
    }

    // Metodo para registrar el detalle del pedido
    public boolean registrarDetalle(int cantidad) {
        if (validarCantidad(cantidad)) {
            this.cantidad = cantidad;
            this.precioUnitario = this.joya.getPrecio();
            this.subtotal = calcularSubtotal();
            return true;
        }
        return false;
    }

    // Resumen para el detalle del pedido
    public String obtenerResumen() {
        return "Joya: " + ((joya != null) ? joya.getNombre() : "N/A") +
                ", cantidad: " + cantidad +
                ", precio: " + precioUnitario +
                ", subtotal: " + subtotal;
    }
}

