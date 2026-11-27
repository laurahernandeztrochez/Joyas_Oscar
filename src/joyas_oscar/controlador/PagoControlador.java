package joyas_oscar.controlador;

import joyas_oscar.modelo.Pago;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.repositorio.PagoRepositorio;
import java.util.ArrayList;

public class PagoControlador {

private final PagoRepositorio pagoRepo;

public PagoControlador(PagoRepositorio pagoRepo) {
    this.pagoRepo = pagoRepo;
}

    // 1. LISTAR - para llenar la tabla del Historial
    public ArrayList<Pago> listarPagos() {
        return pagoRepo.listar();
    }

    // 2. REGISTRAR - lo que hace el botón Registrar de tu ventana
    public void registrarPago(Pedido pedido, double monto, String metodoPago, String estado, String fechaPago) {
        // Validaciones básicas, igual que en los otros controladores
        if (pedido == null) {
            throw new IllegalArgumentException("Debes seleccionar un pedido");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }

        // OJO: El orden es el mismo que arreglamos en el repositorio
        // id, Pedido, monto, metodo, estado, fecha
        Pago pago = new Pago(0, pedido, monto, metodoPago, estado, fechaPago);
        pagoRepo.guardar(pago);
    }

    // 3. BUSCAR POR ID - para cuando buscas un pedido o un pago
    public Pago buscarPorId(int idPago) {
        return pagoRepo.buscarPorId(idPago);
    }

    // 4. ACTUALIZAR - para el botón Editar
    public boolean actualizarPago(Pago pago) {
        return pagoRepo.actualizar(pago);
    }

    // 5. ELIMINAR - para el botón Eliminar de la tabla
    public boolean eliminarPago(int idPago) {
        return pagoRepo.eliminar(idPago);
    }

    // 6. BUSCAR POR CLIENTE - para la barrita de "Buscar por Cliente" de tu mockup
    public ArrayList<Pago> buscarPorCliente(String nombreCliente) {
        ArrayList<Pago> todos = pagoRepo.listar();
        ArrayList<Pago> resultado = new ArrayList<>();

        if (nombreCliente == null || nombreCliente.isEmpty()) {
            return todos;
        }

        for (Pago p : todos) {
            String nombre = p.getPedido().getCliente().getNombre();
            if (nombre.toLowerCase().contains(nombreCliente.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}