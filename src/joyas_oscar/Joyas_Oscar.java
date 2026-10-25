
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
public class Joyas_Oscar {

    
    public static void main(String[] args) {
        //Pruebas
        //clase cliente
       Cliente cliente1 = new Cliente(1, "Juan", "Perez", "3108235971", "33d #76-28");
       System.out.println(cliente1);
       
       
       //Clase joya
       Joya joya1 = new Joya(1,"anillo Laura","plata",28000.0,7);

       System.out.println("--- Probando venta ---");
    
    if (joya1.registrarVenta(3)) {
        System.out.println("Venta de 3 realizada");
    } else {
        System.out.println("No hay stock suficiente");
    }
    System.out.println(joya1);
    
    //prueba clase material
    
    System.out.println("Material");
    Material material1 = new Material(1,2.8,10,"joya 23","Oro",57000.0);
    System.out.println(material1);
    
    //Prueba pago
 
    Pago pago1 = new Pago(1,null,39000.0,"Nequi","Pagado","24 de octubre");
    System.out.println(pago1.generarComprobante());
    
    //Prueba de pedido
    System.out. println("Pedido");
    Pedido pedido1= new Pedido(1,cliente1,"Enviado","Calle 33D 17-75");
    System.out.println(pedido1);
    
    
    }

}
    
    
    
    

