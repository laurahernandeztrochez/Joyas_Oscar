package joyas_oscar.controlador;

import joyas_oscar.modelo.Pedido;
import joyas_oscar.modelo.DetallePedido;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.repositorio.PedidoRepositorio;
import java.util.ArrayList;

public class PedidoControlador {
    
    private PedidoRepositorio pedidos;

    public PedidoControlador(PedidoRepositorio pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> listarPedido() {
        return pedidos.listar();
    }
    
      public ArrayList<Pedido> buscarPedido(String nombre) {
        return pedidos.buscarPorCliente(nombre);
    }

    public String guardarPedido(Cliente cliente, String estado, String direccion, String fecha, ArrayList<DetallePedido> detalles) {
        if (cliente == null) {
            return "Selecciona un cliente";
        }
        if (direccion == null || direccion.trim().isEmpty()) {
            return "La direccion es obligatoria";
        }
        if (fecha == null || fecha.trim().isEmpty()) {
            return "La fecha es obligatoria";
        }
        if (detalles == null || detalles.isEmpty()) {
            return "Agrega al menos una joya";
        }

        double total = 0;
        for (DetallePedido d : detalles) {
            total += d.getSubTotal();
        }

        Pedido p = new Pedido();
        p.setCliente(cliente);
        p.setEstado(estado.trim());
        p.setDireccion(direccion.trim());
        p.setFecha(fecha);
        p.setTotal(total);
        p.setDetalles(detalles);

        pedidos.guardar(p);
        return "Pedido guardado - Total: " + total;
    }

    public String actualizarPedido(int idPedido, Cliente cliente, String estado, String direccion, String fecha, ArrayList<DetallePedido> detalles) {
        Pedido p = pedidos.buscarPorId(idPedido);
        if (p == null) {
            return "Seleccione un pedido de la tabla";
        }

        double total = 0;
        for (DetallePedido d : detalles) {
            total += d.getSubTotal();
        }

        p.setCliente(cliente);
        p.setEstado(estado.trim());
        p.setDireccion(direccion.trim());
        p.setFecha(fecha);
        p.setTotal(total);
        p.setDetalles(detalles);

        pedidos.actualizar(p);
        return "Pedido actualizado";
    }

    public String desactivarPedido(int idPedido) {
        Pedido p = pedidos.buscarPorId(idPedido);
        if (p == null) {
            return "Seleccione un pedido de la tabla";
        }
        pedidos.cancelar(idPedido);
        return "Pedido eliminado";
    }
  
}