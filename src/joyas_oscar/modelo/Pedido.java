
package joyas_oscar.modelo;

import java.util.List;

public class Pedido {
    
    private int idPedido;
    private Cliente cliente;
    private String estado;
    private String direccion;
    private List<DetallePedido> detalles;
  
    
    public Pedido(int idPedido, Cliente cliente,String estado, String direccion){
        this.idPedido  = idPedido;
        this.cliente = cliente;
        this.estado = estado;
        this.direccion = direccion;
        this.detalles = new ArrayList<>();
    }
    
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
    
    public List<DetallePedido> getDetalles() {
        return detalles;
    }
    
   public void setDetalles(List<DetallePedido> detalles) {
       this.detalles = detalles;
   }
   
   
    //Metodo validarEstado
    public boolean validarEstado(String estado) {
        if (estado==null) return false; 
        String e = estado.toLowerCase().trim();
        return e.equals("Pendiente") || e.equals("Enviado") || e.equals("Entregado");
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
    
    //Metodo validarDireccion
    public boolean validarDireccion () {
        if (this.direccion==null) {
            return false;
        }
        String d = this.direccion.trim();
        return !d.isEmpty() && d.length() >5;
    }
}
    
    //Metodo calcularTotal
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i <detalles.size(); i++) {
        total = total + detalles.get(i).getSubtotal();
    }
        return total;
    }
 
   
}
