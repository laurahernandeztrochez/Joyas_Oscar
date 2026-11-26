package joyas_oscar.Pruebas;

import joyas_oscar.controlador.PedidoControlador;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.modelo.DetallePedido;
import joyas_oscar.modelo.Joya;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.repositorio.PedidoRepositorio;
import java.util.ArrayList;

public class PruebaPedidoControlador {

    public static void main(String[] args) {
        // 1. Creamos repositorio y controlador
        PedidoRepositorio repo = new PedidoRepositorio();
        PedidoControlador controlador = new PedidoControlador(repo);

        // 2. Creamos un cliente
        Cliente cliente = new Cliente("Maria" ,"Lopez", "1234567886", "Calle 5 27-9");
        cliente.setIdCliente(2);
        // 3. Creamos 2 joyas
        Joya joya1 = new Joya();
        joya1.setNombre("Anillo de oro");
        joya1.setPrecio(150000.0);

        Joya joya2 = new Joya();
        joya2.setNombre("Aretes plata");
        joya2.setPrecio(50000.0);
        
        joya1.setIdJoya(1);
        joya2.setIdJoya(3);

        // 4. Creamos los detalles con esas joyas
        // El Pedido va en null porque todavia no existe, el controlador lo pone al guardar
        ArrayList<DetallePedido> detalles = new ArrayList<>();
        detalles.add(new DetallePedido(null, joya1, 1));
        detalles.add(new DetallePedido(null, joya2, 2));
        // Total esperado: 150000 + (50000*2) = 250000

        // 5. PROBAR GUARDAR
        System.out.println("--- GUARDAR ---");
        String mensaje = controlador.guardarPedido(cliente, "Pendiente", "Calle 5 # 10-20", "2026-11-25", detalles);
        System.out.println(mensaje);

        // 6. PROBAR LISTAR
        System.out.println("\n--- LISTAR ---");
        ArrayList<Pedido> lista = controlador.listarPedido();
        System.out.println("Hay " + lista.size() + " pedidos");
        for (Pedido p : lista) {
            System.out.println(p.getIdPedido() + " - " + p.getCliente().getNombre() + " - Total: " + p.getTotal());
        }

        // 7. PROBAR BUSCAR POR CLIENTE
        System.out.println("\n--- BUSCAR POR CLIENTE ID 1 ---");
        ArrayList<Pedido> encontrados = controlador.buscarPedido(1);
        System.out.println("Encontrados: " + encontrados.size());

        // 8. PROBAR ACTUALIZAR
        System.out.println("\n--- ACTUALIZAR ---");
        int idAActualizar = lista.get(0).getIdPedido();
        String mensaje2 = controlador.actualizarPedido(idAActualizar, cliente, "Entregado", "Calle 5 # 10-20", "2026-11-25", detalles);
        System.out.println(mensaje2);

        // 9. PROBAR CANCELAR
        System.out.println("\n--- CANCELAR ---");
        String mensaje3 = controlador.desactivarPedido(idAActualizar);
        System.out.println(mensaje3);
        System.out.println("Ahora hay " + controlador.listarPedido().size() + " pedidos");
    }
}