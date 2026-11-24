
package joyas_oscar.Pruebas;
import joyas_oscar.repositorio.MaterialRepositorio;
import joyas_oscar.modelo.Material;



public class PruebaMaterialRepositorio {
       public static void main(String[] args) {

        MaterialRepositorio materiales = new MaterialRepositorio();
     

        // 1. Listar: los 15 materiales registrados.
        for (Material m : materiales.listar()) {
            System.out.println(m.getIdMaterial() + ". " + m.obtenerResumen());
        }

        // 2. Buscar por id
        System.out.println("¿Existe 1? " + (materiales.buscarPorId(1) != null));   // true
        System.out.println("¿Existe 6? " + (materiales.buscarPorId(2) != null));   // true
        System.out.println("¿Existe 10? " + (materiales.buscarPorId(10) != null));   // false

        // 3. Buscar por nombre (RF6).
        System.out.println("Con 'Or': " + materiales.buscarPorNombre("or").size() + " materiales");   // 1 Oro amarillo

      
        Material PLata = materiales.buscarPorId(2);
 
        // 5. Desactivar Titanio: deja de aparecer en listar(), pero SIGUE en MySQL.
        materiales.desactivar(3);
        System.out.println("Materiales activos: " + materiales.listar().size());     // 4 (anteriormente 5 antes de desactivar titanio
        System.out.println("¿Titanio sigue en MySQL? " + (materiales.buscarPorId(3) != null));   // true
    }
    
}
