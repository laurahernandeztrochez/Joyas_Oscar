package joyas_oscar.pruebas;

import joyas_oscar.modelo.Pago;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.repositorio.PagoRepositorio;
import joyas_oscar.repositorio.PedidoRepositorio;
import java.util.ArrayList;

public class PruebaPagoRepositorio {
    public static void main(String[] args) {
        PagoRepositorio repo = new PagoRepositorio();
        PedidoRepositorio pedidoRepo = new PedidoRepositorio();

        // OJO: Tienes que usar un id_pedido que SÍ exista en tu base de datos
        // Si no existe, te va a dar error de llave foránea
        Pedido pedido = pedidoRepo.buscarPorId(1);
        System.out.println("Pedido encontrado: " + pedido);

        if (pedido == null) {
            System.out.println("No hay pedido con ese id.");
            return;
        }

        // 1. GUARDAR
        System.out.println("\n--- 1. GUARDAR ---");
        Pago nuevo = new Pago(0, pedido, 50000, "Efectivo", "Pagado", "2026-11-27");
        repo.guardar(nuevo);
        System.out.println("Guardado con id: " + nuevo.getIdPago());

        // 2. LISTAR
        System.out.println("\n--- 2. LISTAR ---");
        ArrayList<Pago> lista = repo.listar();
        for (Pago p : lista) {
            System.out.println(p.getIdPago() + " | " + p.getFechaPago() + " | " + p.getMonto() + " | " + p.getEstado() + " | Cliente: " + p.getPedido().getCliente().getNombre());
        }

        // 3. BUSCAR POR ID
        System.out.println("\n--- 3. BUSCAR POR ID ---");
        Pago encontrado = repo.buscarPorId(nuevo.getIdPago());
        System.out.println("Encontrado: " + encontrado.getMonto() + " - " + encontrado.getEstado());

        // 4. ACTUALIZAR
        System.out.println("\n--- 4. ACTUALIZAR ---");
        encontrado.setEstado("Pendiente");
        encontrado.setMonto(60000);
        boolean actualizado = repo.actualizar(encontrado);
        System.out.println("¿Se actualizó? " + actualizado);

        // 5. ELIMINAR
        System.out.println("\n--- 5. ELIMINAR ---");
        boolean eliminado = repo.eliminar(nuevo.getIdPago());
        System.out.println("¿Se eliminó? " + eliminado);

        System.out.println("\n--- FIN DE LA PRUEBA ---");
    }
}