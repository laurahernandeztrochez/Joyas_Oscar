
package joyas_oscar.Pruebas;
import joyas_oscar.repositorio.ClienteRepositorio;
import joyas_oscar.modelo.Cliente;

/**
 * Clase destinada a probar manualmente las operaciones del repositorio
 * de clientes.
 * Si da el resultado esperado
 */
public class PruebaClienteRepositorio {
    
      public static void main(String[] args) {

        ClienteRepositorio clientes = new ClienteRepositorio();

        // 1. Listar: los 9 clientes activos del script 02 (Paola Mejía está desactivada).
        for (Cliente c : clientes.listar()) {
            System.out.println(c.getIdCliente() + ". " + c.getNombreCompleto());
        }

        // 2. Buscar por nombre.
        System.out.println("¿Existe Laura? " + (clientes.buscarPorNombre("Laura") != null));   // true (Laura Hernandez)
        System.out.println("¿Existe Sofia? " + (clientes.buscarPorNombre("Sofia") != null));   // false

        // 3. Guardar uno nuevo: MySQL le asigna el id 10.
        Cliente Karen = new Cliente("Karen", "Díaz", "3001112233", "la floresta calle 33d #76-45");
        clientes.guardar(Karen);
        System.out.println("Id de Karen en MySQL: " + Karen.getIdCliente());                              // 11

        // 4. Actualizar su teléfono.
        Karen.setTelefono("3159998877");
        clientes.actualizar(Karen);
        System.out.println("Nuevo teléfono: " + clientes.buscarPorId(Karen.getIdCliente()).getTelefono()); // 3159998877

        // 5. Desactivarla: deja de aparecer en listar(), pero SIGUE en MySQL.
        clientes.desactivar(Karen.getIdCliente());
        System.out.println("Clientes activos: " + clientes.listar().size());                        // 5
        System.out.println("¿Karen sigue en MySQL? " + (clientes.buscarPorId(Karen.getIdCliente()) != null)); // true
    }
    
}
