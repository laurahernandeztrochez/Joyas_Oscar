package joyas_oscar.controlador;

import java.util.ArrayList;
import joyas_oscar.modelo.Material;
import joyas_oscar.repositorio.MaterialRepositorio;

/**
 * Valida y coordina las acciones sobre materiales entre la interfaz
 * y el repositorio de materiales.
 */
public class MaterialControlador {

    private final MaterialRepositorio materiales;

    public MaterialControlador(MaterialRepositorio materiales) {
        this.materiales = materiales;
    }

    public ArrayList<Material> listarMateriales() {
        return materiales.listar();
    }

    public Material buscarMaterialPorId(int idMaterial) {
        return materiales.buscarPorId(idMaterial);
    }

    public ArrayList<Material> buscarMaterialPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Escriba el nombre del material que desea buscar");
        }
        return materiales.buscarPorNombre(nombre.trim());
    }

    public String guardarMaterial(String nombre, String tipoMaterial, int stock,
            double peso, double precio) {
        String error = validarDatos(nombre, tipoMaterial, stock, peso, precio);
        if (error != null) {
            return error;
        }

        double total = peso * precio;
        Material material = new Material(
                0, peso, stock, nombre.trim(), tipoMaterial.trim(), precio, total, true);
        materiales.guardar(material);
        return "Material guardado";
    }

    public String actualizarMaterial(int idMaterial, String nombre, String tipoMaterial,
            int stock, double peso, double precio) {
        Material material = materiales.buscarPorId(idMaterial);
        if (material == null) {
            return "Seleccione un material existente";
        }

        String error = validarDatos(nombre, tipoMaterial, stock, peso, precio);
        if (error != null) {
            return error;
        }

        material.setNombre(nombre.trim());
        material.setTipoMaterial(tipoMaterial.trim());
        material.setStock(stock);
        material.setPeso(peso);
        material.setPrecio(precio);
        material.setTotal(peso * precio);
        return materiales.actualizar(material)
                ? "Material actualizado"
                : "No se pudo actualizar el material";
    }

    public String desactivarMaterial(int idMaterial) {
        Material material = materiales.buscarPorId(idMaterial);
        if (material == null || !material.isActivo()) {
            return "Seleccione un material activo";
        }
        return materiales.desactivar(idMaterial)
                ? "Material desactivado"
                : "No se pudo desactivar el material";
    }

    private String validarDatos(String nombre, String tipoMaterial, int stock,
            double peso, double precio) {
        if (nombre == null || nombre.trim().isEmpty()
                || tipoMaterial == null || tipoMaterial.trim().isEmpty()) {
            return "El nombre y el tipo de material son obligatorios";
        }
        if (stock < 0) {
            return "El stock no puede ser negativo";
        }
        if (!(peso > 0) || Double.isInfinite(peso)) {
            return "El peso debe ser un valor mayor que cero";
        }
        if (!(precio > 0) || Double.isInfinite(precio)) {
            return "El precio debe ser un valor mayor que cero";
        }
        if (Double.isInfinite(peso * precio)) {
            return "El total calculado excede el valor permitido";
        }
        return null;
    }
}
