//hello
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
import joyas_oscar.modelo.Usuario;
import joyas_oscar.modelo.Rol;
import joyas_oscar.repositorio.ClienteRepositorio;
import joyas_oscar.controlador.ClienteControlador;
 /*
import joyas_oscar.vista.VentanaCliente;
import joyas_oscar.vista.VentanaLogin;
import joyas_oscar.vista.VentanaUsuario;
import joyas_oscar.vista.VentanaInicio;
*/

/**
 * Punto de entrada del programa: inicia la aplicación en el hilo de eventos
 * de Swing y muestra la ventana de inicio de sesión.
 */
public class Joyas_Oscar {

    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Aplicacion().iniciar();
        });
    }
}
        
//new VentanaCliente(new ClienteControlador(new ClienteRepositorio())).setVisible(true);
          // java.awt.EventQueue.invokeLater(() -> new VentanaUsuario ().setVisible(true));
           
          
      //  java.awt.EventQueue.invokeLater(() -> {
           // VentanaInicio inicio = new VentanaInicio();
         //   inicio.setVisible(true);
       // });
    
        
        /* 
    Cliente cliente1 = new Cliente(1, "Juan", "Perez", "1234567890", "calle 33 d# 76-90");
    Joya joya1 = new Joya(1, "anillo Laura", "plata", 28000.0, 7);
    Pedido pedido1 = new Pedido(1, cliente1, "Enviado", "Calle 33D 17-75", "2027-02-25");
    DetallePedido detallepedido1 = new DetallePedido(1, joya1, 3);
    Pago pago1 = new Pago(1, pedido1, 39000.0, "Nequi", "Pagado", "24 de octubre");
    Material material1 = new Material(1,28.9,7,"Caja 2","Oro",10000.0);
    Usuario usuario1 = new Usuario();
    Rol rol1 = new Rol();
       
    
    //tOTAL DEL PEDIDO 
    pedido1.setTotal(detallepedido1.getSubTotal());

  
    System.out.println("--- Probando pedido ---");
    System.out.println("Resumen: ID pedido: " + pedido1.getIdPedido() + ", ID Cliente: " + cliente1.getIdCliente() + " (" + cliente1.getNombre() + "), Direccion Envio: " + pedido1.getDireccion() + ", Estado: " + pedido1.getEstado() + ", Fecha pedido: " + pedido1.getFecha() + ", total: " + pedido1.getTotal());

    System.out.println("--- Probando pago ---");
    System.out.println(pago1.generarComprobante());

    System.out.println("--- Probando detalle---");
    System.out.println(detallepedido1.obtenerResumen());
    
    System.out.println("--- Probando material---");
    System.out.println(material1);
    
    System.out.println("--- Probando Usuario---");
    System.out.println(usuario1);
    
    System.out.println("--- Probando Rol---");
    System.out.println(rol1);*/
    
  



    
    
    
    

