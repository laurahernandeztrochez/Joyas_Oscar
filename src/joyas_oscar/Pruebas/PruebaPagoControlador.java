package joyas_oscar.pruebas;

import joyas_oscar.controlador.PagoControlador;
import joyas_oscar.modelo.Pago;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.repositorio.PedidoRepositorio;
import java.util.ArrayList;

public class PruebaPagoControlador {
    public static void main(String[] args) {
        PagoControlador controlador = new PagoControlador();
        PedidoRepositorio pedidoRepo = new PedidoRepositorio();

        // 1. Necesitas un pedido que sí exista, igual que antes
        Pedido pedido = pedidoRepo.buscarPorId(1);
        if (pedido == null) {
            System.out.println("No hay pedido con ese id");
            return;
        }

        // 2. REGISTRAR por el controlador
        System.out.println("--- REGISTRAR ---");
        try {
            controlador.registrarPago(pedido, 75000, "Efectivo", "Pagado", "2026-11-27");
            System.out.println("Se registró bien");
        } catch (Exception e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }

        // 3. LISTAR por el controlador
        System.out.println("\n--- LISTAR ---");
        ArrayList<Pago> lista = controlador.listarPagos();
        for (Pago p : lista) {
            System.out.println(p.getIdPago() + " | " + p.getMonto() + " | " + p.getEstado() + " | Cliente: " + p.getPedido().getCliente().getNombre());
        }

        // 4. BUSCAR POR CLIENTE - esto es lo nuevo del controlador
        System.out.println("\n--- BUSCAR POR CLIENTE 'Laura' ---");
        ArrayList<Pago> deLaura = controlador.buscarPorCliente("Laura");
        for (Pago p : deLaura) {
            System.out.println(p.getIdPago() + " | " + p.getPedido().getCliente().getNombre());
        }

        // 5. ACTUALIZAR Y ELIMINAR
        System.out.println("\n--- ACTUALIZAR Y ELIMINAR ---");
        Pago ultimo = lista.get(lista.size() - 1); // el que acabamos de crear
        ultimo.setEstado("Pendiente");
        System.out.println("¿Actualizó? " + controlador.actualizarPago(ultimo));
        System.out.println("¿Eliminó? " + controlador.eliminarPago(ultimo.getIdPago()));

        // 6. PROBAR LA VALIDACIÓN - tiene que fallar
        System.out.println("\n--- PROBAR VALIDACIÓN (debe dar error) ---");
        try {
            controlador.registrarPago(pedido, 0, "Efectivo", "Pagado", "2026-11-27");
            System.out.println("¡OJO! Dejó registrar monto 0, la validación no sirve");
        } catch (Exception e) {
            System.out.println("Bien, la validación sí sirve: " + e.getMessage());
        }

        System.out.println("\n--- FIN DE LA PRUEBA ---");
    }
}