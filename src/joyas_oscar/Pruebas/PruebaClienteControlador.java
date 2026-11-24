
package joyas_oscar.Pruebas;
import joyas_oscar.controlador.ClienteControlador;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.repositorio.ClienteRepositorio;


public class PruebaClienteControlador {
        
 public static void main(String[] args) {
     ClienteRepositorio clientes = new ClienteRepositorio();
        ClienteControlador controlador = new ClienteControlador(clientes);

        // 1. Validaciones de guardar.
        System.out.println(controlador.guardarCliente("James", "Rodriguez", "" , ""));          // telefono vacío
        System.out.println(controlador.guardarCliente("James", "Rodriguez","1234567892", ""));   // telefono de Laura Hernandez

        // 2. Guardar con datos correctos.
        System.out.println(controlador.guardarCliente("James", "Rodriguez","0000000004","direccion"));

        // 3. Buscar: el que existe y uno desactivado (Paola Mejía, 7788990).
        //    Si el cliente no existe (o está desactivado), buscarCliente devuelve null:
        //    hay que revisarlo ANTES de usarlo, o Java lanza NullPointerException.
        Cliente laura = controlador.buscarCliente("Laura");
        System.out.println("Buscar Laura: " + (laura != null ? laura.getNombreCompleto() : "existe"));   // Laura Hernandez
        System.out.println("Buscar Sodia: " + controlador.buscarCliente("Sodia"));                    // null

        // 4. Actualizar a Juan buitrago(id 2): primero con el numero de otro cliente, luego bien.
        System.out.println(controlador.actualizarCliente(2, "Juan","Buitrago","1234567894","direccion")); //telefono ya existe
        System.out.println(controlador.actualizarCliente(2, "Juan","Buitrago","1234567898","direccion")); //Deberia actualizar

        // 5. Eliminar: el Consumidor final (id 1) no se puede; Carlos Ruiz (id 3) sí.
        System.out.println(controlador.desactivarCliente(1));
        System.out.println(controlador.desactivarCliente(3));
        System.out.println(controlador.desactivarCliente(99));
        System.out.println("Clientes activos: " + controlador.listarClientes().size());   // 4
    }
}
