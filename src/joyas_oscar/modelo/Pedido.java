
package joyas_oscar.modelo;


public class Pedido {
    
    private int idPedido;
    private int idCliente;
    private String nombre;
    private String estado;
    private double total;
    private String direccion;
    private double subtotal;
   
    
    public Pedido(int idPedido, int idCliente, String nombre, String estado, double total, String direccion, double subtotal){
        this.idPedido  = idPedido;
        this.idCliente = idCliente;
        this.nombre = nombre; 
        this.estado = estado;
        this.total = total;
        this.direccion = direccion;
        this.subtotal = subtotal;
    }
    
    public int getIdPedido() {
    return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

      public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     public Double getSubTotal() {
        return subtotal;
    }

    public void setSubTotal(Double subtotal) {
        this.subtotal = subtotal;
    }
   
    //Metodo validarEstado
    public boolean validarEstado(String estado) {
        if (estado==null) {
            return false; 
        } else {
            String e = estado.toLowerCase().trim();
            if (e.equals("pendiente") || e.equals("enviado") || e.equals("entregado")) {
                return true;
            } else {
                return false;
            }
        }
    }
 
   
}
