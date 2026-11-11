
package joyas_oscar.repositorio;

import joyas_oscar.modelo.Cliente;
import java.util.ArrayList;

public class ClienteRepositorio {
    // Lista donde se almacenan todos los clientes del sistema.
    // Esta estructura permite guardar, buscar, editar, eliminar y listar clientes.
    private ArrayList<Cliente> lista = new ArrayList<>();

    // ------------------------------------------------------------
    // guardar(): agrega un nuevo cliente a la lista.
    // Funciona como el botón "Guardar" del formulario.
    // ------------------------------------------------------------
    public void guardar(Cliente c) {
        lista.add(c);
    }

    // ------------------------------------------------------------
    // editar(): busca un cliente por su id y reemplaza sus datos.
    // Funciona como el botón "Editar" del formulario.
    // Recibe el cliente ya actualizado con los nuevos datos.
    // ------------------------------------------------------------
    public void editar(Cliente cEditado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdCliente() == cEditado.getIdCliente()) {
                lista.set(i, cEditado); // reemplaza el registro anterior con el nuevo
                break; // sale del ciclo porque ya encontró el cliente
            }
        }
    }

    // ------------------------------------------------------------
    // eliminar(): elimina un cliente usando su id.
    // Funciona como el botón "Eliminar" del formulario.
    // Busca el cliente y lo borra de la lista.
    // ------------------------------------------------------------
    public void eliminar(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdCliente() == id) {
                lista.remove(i); // elimina la posición encontrada
                break; // deja de buscar porque ya se eliminó
            }
        }
    }

    // ------------------------------------------------------------
    // limpiar(): elimina todos los clientes de la lista.
    // Funciona como el botón "Limpiar" o "Vaciar".
    // ------------------------------------------------------------
    public void limpiar() {
        lista.clear();
    }

    // ------------------------------------------------------------
    // buscarPorId(): busca un cliente por su identificador.
    // Devuelve el objeto Cliente si existe; si no, devuelve null.
    // Se usa para cargar datos de un cliente específico.
    // ------------------------------------------------------------
    public Cliente buscarPorId(int id) {
        for (Cliente c : lista) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    // ------------------------------------------------------------
    // existeId(): valida si ya existe un cliente con ese id.
    // Sirve para evitar duplicados antes de guardar o editar.
    // Retorna true si el id ya está en uso.
    // ------------------------------------------------------------
    public boolean existeId(int id) {
        for (Cliente c : lista) {
            if (c.getIdCliente() == id) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // existeTelefono(): valida si ya existe un número de teléfono en la lista.
    // Se usa para evitar registrar dos clientes con el mismo teléfono.
    // Retorna true si el teléfono ya existe.
    // ------------------------------------------------------------
    public boolean existeTelefono(String tel) {
        for (Cliente c : lista) {
            if (c.getTelefono() != null && c.getTelefono().equals(tel)) {
                return true;
            }
        }
        return false;
    }

    // =====================================================================
    // datosPrueba(): crea algunos clientes de ejemplo para probar la aplicación.
    // Solo se usa en pruebas o para iniciar datos temporales.
    // No es un botón visual; es un método auxiliar para cargar información.
    // =====================================================================
    private void datosPrueba() {
        guardar(new Cliente(1, "Juan Perez", "1234567890", null, null));
        guardar(new Cliente(2, "Maria Garcia", "0987654321", null, null));
    }

    // ------------------------------------------------------------
    // listar(): devuelve la lista completa de clientes.
    // Funciona para mostrar todos los datos en una tabla o vista.
    // ------------------------------------------------------------
    public ArrayList<Cliente> listar() {
        return lista;
    }
}


