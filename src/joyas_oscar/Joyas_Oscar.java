
package joyas_oscar;

/**
 * @author Laura Hernandez
 * Juan Pablo Toro
 * Jhosep Nuñez
 * Grupo 327
 */
import joyas_oscar.modelo.Cliente;
import joyas_oscar.modelo.Joya;
import joyas_oscar.modelo.Material;
import joyas_oscar.modelo.Pago;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.modelo.DetallePedido;

public class Joyas_Oscar {

    
    public static void main(String[] args) {
        
        
        // 1. CREAR TODO PRIMERO
    Cliente cliente1 = new Cliente(1, "Juan", "Perez", "1234567890", "calle 33 d# 76-90");
    Joya joya1 = new Joya(1, "anillo Laura", "plata", 28000.0, 7);
    Pedido pedido1 = new Pedido(1, cliente1, "Enviado", "Calle 33D 17-75", "25 de febrero 2027");
    DetallePedido detallepedido1 = new DetallePedido(1, joya1, 3);
    Pago pago1 = new Pago(1, pedido1, 39000.0, "Nequi", "Pagado", "24 de octubre");
    
    // 2. PONERLE EL TOTAL AL PEDIDO (ESTO ES LO IMPORTANTE)
    pedido1.setTotal(detallepedido1.getSubTotal());

    // 3. AHORA SI IMPRIMIR
    System.out.println("--- Probando pedido ---");
    System.out.println("Resumen: ID pedido: " + pedido1.getIdPedido() + ", ID Cliente: " + cliente1.getIdCliente() + " (" + cliente1.getNombre() + "), Direccion Envio: " + pedido1.getDireccion() + ", Estado: " + pedido1.getEstado() + ", Fecha pedido: " + pedido1.getFecha() + ", total: " + pedido1.getTotal());

    System.out.println("--- Probando pago ---");
    System.out.println(pago1.generarComprobante());

    System.out.println("--- Probando detalle---");
    System.out.println(detallepedido1.obtenerResumen());
    }
} 


    
    
    
    

