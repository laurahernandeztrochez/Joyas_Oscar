/*
 *  ¿PARA QUÉ SIRVE?
 *    Recibe los datos de la ventana, los valida
 *    y si es valido, se guarda en el repositorio
 *    No toca los botones ni el MySQL directo */

package joyas_oscar.controlador;

import java.util.ArrayList;
import joyas_oscar.modelo.Joya;
import joyas_oscar.repositorio.JoyaRepositorio;

public class JoyaControlador {

    private JoyaRepositorio joyas;

    public JoyaControlador(JoyaRepositorio joyas) {
        this.joyas = joyas;
    }

    public ArrayList<Joya> listarJoya() {
        return joyas.listar();
    }

    // Busca joyas activas por nombre, devuelve lista
    public ArrayList<Joya> buscarJoya(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return joyas.listar();
        }
        return joyas.buscarPorNombre(nombre.trim());
    }

    // Guardar
    public String guardarJoya(String nombre, String material, double precio, int stock) {
        if (nombre == null || nombre.trim().isEmpty() || material == null || material.trim().isEmpty()) {
            return "El tipo de material y el nombre son obligatorios";
        }
        if (precio < 0 || stock < 0) {
            return "Precio y stock no pueden ser negativos";
        }

        Joya j = new Joya();
        j.setNombre(nombre.trim());
        j.setMaterial(material.trim());
        j.setPrecio(precio);
        j.setStock(stock);
        j.setActivo(true);

        joyas.guardar(j);
        return "Joya guardada";
    }

    // Actualizar
    public String actualizarJoya(int idJoya, String nombre, String material, double precio, int stock) {
        Joya j = joyas.buscarPorId(idJoya);
        if (j == null) {
            return "Seleccione una joya de la tabla";
        }
        if (nombre == null || nombre.trim().isEmpty() || material == null || material.trim().isEmpty()) {
            return "El tipo de material y el nombre son obligatorios";
        }
        if (precio < 0 || stock < 0) {
            return "Precio y stock no pueden ser negativos";
        }

        // Revisa si ya existe otra joya con ese nombre
        ArrayList<Joya> otras = joyas.buscarPorNombre(nombre.trim());
        for (Joya otro : otras) {
            if (otro.getIdJoya() != idJoya) {
                return "Ya existe otra joya con ese nombre";
            }
        }

        j.setNombre(nombre.trim());
        j.setMaterial(material.trim());
        j.setPrecio(precio); // <- sin trim, es double
        j.setStock(stock);   // <- sin trim, es int
        joyas.actualizar(j);
        return "Joya actualizada";
    }

    // Eliminar
    public String desactivarJoya(int idJoya) {
        Joya j = joyas.buscarPorId(idJoya);
        if (j == null) {
            return "Seleccione una joya de la tabla";
        }
        joyas.desactivar(idJoya);
        return "Joya eliminada";
    }
}