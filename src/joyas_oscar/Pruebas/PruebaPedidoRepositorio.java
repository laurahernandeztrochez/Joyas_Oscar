package joyas_oscar.pruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.modelo.DetallePedido;
import joyas_oscar.modelo.Joya;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.repositorio.ClienteRepositorio;
import joyas_oscar.repositorio.JoyaRepositorio;
import joyas_oscar.repositorio.PedidoRepositorio;

/*
 * Prueba de PedidoRepositorio.
 * ANTES de correrla: en la BD debe existir un cliente con id 1 y una joya
 * con id 1 que tenga stock (ajusta las constantes de abajo si usas otros ids).
 */
public class PruebaPedidoRepositorio {

    private static final int ID_CLIENTE = 2;
    private static final int ID_JOYA = 1;

    public static void main(String[] args) {
        PedidoRepositorio pedidoRepo = new PedidoRepositorio();
        ClienteRepositorio clienteRepo = new ClienteRepositorio();
        JoyaRepositorio joyaRepo = new JoyaRepositorio();

        Cliente cliente = clienteRepo.buscarPorId(ID_CLIENTE);
        Joya joya = joyaRepo.buscarPorId(ID_JOYA);
        System.out.println("Stock inicial de la joya: " + joya.getStock()); //12

        // ---------------- 1. GUARDAR ----------------
        System.out.println("\n=== 1. GUARDAR ===");
        Pedido pedido = new Pedido(0, cliente, "pendiente",
                "Calle 10 # 5-20", LocalDate.now().toString());

        ArrayList<DetallePedido> detalles = new ArrayList<>();
        detalles.add(new DetallePedido(pedido, joya, 2));

        if (pedido.registrarPedido(detalles)) { // valida y calcula el total
            pedidoRepo.guardar(pedido);
            System.out.println("Pedido guardado con id: " + pedido.getIdPedido());
        } else {
            System.out.println("El pedido no es válido (revisa dirección y estado).");
            return;
        }
        System.out.println("Stock después de guardar (debe bajar 2): "
                + joyaRepo.buscarPorId(ID_JOYA).getStock());

        // ---------------- 2. BUSCAR POR ID (con detalles) ----------------
        System.out.println("\n=== 2. BUSCAR POR ID ===");
        Pedido encontrado = pedidoRepo.buscarPorId(pedido.getIdPedido());
        System.out.println(encontrado.obtenerResumen());
        for (DetallePedido d : encontrado.getDetalles()) {
            System.out.println("   " + d.obtenerResumen());
        }

        // ---------------- 3. LISTAR ----------------
        System.out.println("\n=== 3. LISTAR ===");
        for (Pedido p : pedidoRepo.listar()) {
            System.out.println(p.obtenerResumen());
        }

        // ---------------- 4. BUSCAR POR CLIENTE / POR ESTADO ----------------
        System.out.println("\n=== 4. POR CLIENTE Y POR ESTADO ===");
        System.out.println("Pedidos del cliente " + ID_CLIENTE + ": "
                + pedidoRepo.buscarPorCliente(ID_CLIENTE).size());
        System.out.println("Pedidos pendientes: "
                + pedidoRepo.listarPorEstado("pendiente").size());

        // ---------------- 5. ACTUALIZAR ESTADO ----------------
        System.out.println("\n=== 5. ACTUALIZAR ESTADO ===");
        boolean actualizado = pedidoRepo.actualizarEstado(pedido.getIdPedido(), "enviado");
        System.out.println("¿Estado actualizado? " + actualizado);
        System.out.println("Nuevo estado: "
                + pedidoRepo.buscarPorId(pedido.getIdPedido()).getEstado());

        // ---------------- 6. STOCK INSUFICIENTE (debe fallar y hacer rollback) ----------------
        System.out.println("\n=== 6. STOCK INSUFICIENTE ===");
        Pedido pedidoGrande = new Pedido(0, cliente, "pendiente",
                "Calle 10 # 5-20", LocalDate.now().toString());
        ArrayList<DetallePedido> detallesGrandes = new ArrayList<>();
        detallesGrandes.add(new DetallePedido(pedidoGrande, joya, 999999));
        pedidoGrande.registrarPedido(detallesGrandes);
        try {
            pedidoRepo.guardar(pedidoGrande);
            System.out.println("ERROR: no debió guardarse.");
        } catch (RuntimeException e) {
            System.out.println("Falló como se esperaba: " + e.getMessage());
            System.out.println("Pedidos en BD no cambió: " + pedidoRepo.listar().size());
        }

        // ---------------- 7. CANCELAR (devuelve el stock) ----------------
        System.out.println("\n=== 7. CANCELAR ===");
        boolean cancelado = pedidoRepo.cancelar(pedido.getIdPedido());
        System.out.println("¿Cancelado? " + cancelado);
        System.out.println("Estado: " + pedidoRepo.buscarPorId(pedido.getIdPedido()).getEstado());
        System.out.println("Stock final (debe volver al inicial): "
                + joyaRepo.buscarPorId(ID_JOYA).getStock());

        // Cancelar otra vez debe fallar
        try {
            pedidoRepo.cancelar(pedido.getIdPedido());
            System.out.println("ERROR: no debió permitir cancelar dos veces.");
        } catch (RuntimeException e) {
            System.out.println("Segundo cancelar falló como se esperaba: " + e.getMessage());
        }
    }
}

