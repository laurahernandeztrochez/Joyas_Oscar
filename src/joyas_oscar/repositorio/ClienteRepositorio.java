
package joyas_oscar.repositorio;

import joyas_oscar.modelo.Cliente;
import java.util.ArrayList;

public class ClienteRepositorio {
    // Lista para almacenar los clientes

    private ArrayList<Cliente> lista = new ArrayList<>();

    // BOTON PARA GUARDAR datos de clientes
    
    public void guardar(Cliente c) {
        lista.add(c);
    }

    // BOTON PARA EDITAR los datos de clientes, recibe un objeto Cliente con los datos editados
    public void editar(Cliente cEditado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdCliente() == cEditado.getIdCliente()) {
                lista.set(i, cEditado);
                break;
            }
        }
    }

    // BOTON PARA ELIMINAR los datos de clientes, recibe el id del cliente a eliminar
/*    public void eliminar(int id) {
        lista.removeIf(c -> c.getIdCliente() == id);
    }
*/  
    public void eliminar(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdCliente() == id) {
                lista.remove(i);
                break;
            }
        }
    }
    
    // BOTON LIMPIAR (limpia toda la lista) y LISTAR
    public void limpiar() {
        lista.clear();
    }
    
   //Para buscar por id
    public Cliente buscarPorId(int id) {
        for (Cliente c : lista) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }
    //Para validar si el id existe ya o no
    public boolean existeId(int id) {
        for (Cliente c : lista){
            if (c.getIdCliente()==id) {
                return true;
            }
        }
        return false;
    }
    
    
    //Para validar si el numero de telefono existe o no
    public boolean existeTelefono(String tel) {
        for (Cliente c : lista) {
            if (c.getTelefono().equals(tel)) {
           return true;  
        }
      }
        return false;
   }
    

        public ArrayList<Cliente> listar() {
        return lista;
    }

    
    
}
  
    

