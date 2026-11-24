
package joyas_oscar.Pruebas;

//Tiene resultados esperados
import joyas_oscar.controlador.MaterialControlador;
import joyas_oscar.modelo.Material;
import joyas_oscar.repositorio.MaterialRepositorio;

public class PruebaMaterialControlador {
    
    public static void main(String[] args) {
    
    MaterialRepositorio materiales = new MaterialRepositorio();
    MaterialControlador controlador = new MaterialControlador(materiales);
    
    
    
        // 1. Validaciones de guardar: cada línea falla por una razón distinta.
        System.out.println(controlador.validarDatos("pruebas","Acero",-3,23,2300)); // stock no puede ser negatio
        System.out.println(controlador.validarDatos("hola","carbon",2,12,0)); // Peso debe ser mayor a 0
        System.out.println(controlador.validarDatos("ola","si",2,34,0)); // Precio debe ser mayor que 0
        System.out.println(controlador.validarDatos("","",2,4,2500)); // nombre y material son obligatorios

        // 2. Guardar con datos correctos: queda guardado EN MYSQL.
        System.out.println(controlador.guardarMaterial("Pueba","prueba1",6,12,4500));

        // 3. El "Oro amarillo" recibió el id que asignó MySQL.
        Material Oro = materiales.buscarPorId(1);
        System.out.println("Id del Oro amarillo en MySQL: " + Oro.getIdMaterial());                // 1

        // 4. Actualizar el Oro amarillo: nuevo precio de venta.
        System.out.println(controlador.actualizarMaterial(Oro.getIdMaterial(), "Oro amarillo","Oro",10,13,60000));
        System.out.println("Nuevo precio: " + materiales.buscarPorId(Oro.getIdMaterial()).getPrecio());   // 60000

        // 5. Eliminar la leche (id 2) y un id que no existe.
        System.out.println(controlador.desactivarMaterial(2));
        System.out.println(controlador.desactivarMaterial(99));
        System.out.println("Materiales activos: " + controlador.listarMateriales().size());   // 3
    
    }
}
