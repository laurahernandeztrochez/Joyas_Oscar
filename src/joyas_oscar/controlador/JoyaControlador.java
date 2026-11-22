/*
 *  ¿PARA QUÉ SIRVE?
*    Recibe los datos de la ventanaCliente, los valida
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

    // Busca un cliente que este: activo y por su numero de telefono con el boton buscar
    // Devuelve null si no existe o si el cliente está desactivado.
    public Joya buscarJoya(String nombre) {
        Joya j = joyas.buscarPorNombre(nombre.trim());
        if (j != null && j.isActivo()) {
            return j;
        }
        return null;
    }

    // Guardar
    public String guardarJoya (String nombre, ) {
        
        if (telefono.trim().isEmpty() || nombre.trim().isEmpty()) {
            return "El telefono y el nombre son obligatorios";              
        }
        
        if (!Cliente.validarTelefono(telefono.trim())) {
            return "El teléfono debe tener 10 digitos";
        }
        if (clientes.buscarPorTelefono(telefono.trim()) != null) {
            return "Ya existe un cliente con ese numero de telefono";                 
        }
        clientes.guardar(new Cliente(nombre.trim(), apellido.trim(), telefono.trim(), direccion.trim()));
        return "Cliente guardado";                                            
    }

    // Actualizar
    public String actualizarCliente(int idCliente, String nombre, String apellido, String telefono, String direccion) {
        Cliente c = clientes.buscarPorId(idCliente);
        if (c == null) {
            return "Seleccione un cliente de la tabla";                       
        }
        if (telefono.trim().isEmpty() || nombre.trim().isEmpty()) {
            return "El numero de telefono y el nombre son obligatorios";
        }
        Cliente otro = clientes.buscarPorTelefono(telefono.trim());
        if (otro != null && otro.getIdCliente() != idCliente) {                          
            return "Ya existe otro cliente con ese numero";
        }
        
        c.setNombre(nombre.trim());
        c.setApellido(apellido.trim());
        c.setTelefono(telefono.trim());
        c.setDireccion(direccion.trim());
        clientes.actualizar(c);
        return "Cliente actualizado";
    }

    // Eliminar
    public String desactivarCliente(int idCliente) {
        Cliente c = clientes.buscarPorId(idCliente);
        if (c == null) {
            return "Seleccione un cliente de la tabla";
        }
        clientes.desactivar(idCliente);
        return "Cliente eliminado";
    }
}
