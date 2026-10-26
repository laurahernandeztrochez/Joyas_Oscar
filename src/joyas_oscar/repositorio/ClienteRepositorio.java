
package joyas_oscar.repositorio;

import joyas_oscar.modelo.Cliente;
import java.util.ArrayList;

public class ClienteRepositorio {
  
    private ArrayList<Cliente> lista = new ArrayList<>();

    // BOTON PARA GUARDAR
    public void guardar(Cliente c) {
        lista.add(c);
    }

    // BOTON PARA EDITAR
    public void editar(Cliente cEditado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdCliente() == cEditado.getIdCliente()) {
                lista.set(i, cEditado);
                break;
            }
        }
    }

    // BOTON PARA ELIMINAR
    public void eliminar(int id) {
        lista.removeIf(c -> c.getIdCliente() == id);
    }

    // BOTON LIMPIAR (limpia toda la lista) y LISTAR
    public void limpiar() {
        lista.clear();
    }
    
    public ArrayList<Cliente> listar() {
        return lista;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : lista) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }
}
  
    

