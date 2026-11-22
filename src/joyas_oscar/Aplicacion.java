package joyas_oscar;

import joyas_oscar.controlador.ClienteControlador;
import joyas_oscar.controlador.LoginControlador;
// Importa aquí tus demás controladores cuando los crees (ej. JoyaControlador, PedidoControlador, etc.)
import joyas_oscar.modelo.Usuario;
import joyas_oscar.repositorio.ClienteRepositorio;
import joyas_oscar.repositorio.UsuarioRepositorio;
// Importa aquí tus demás repositorios (ej. JoyaRepositorio, PedidoRepositorio, PagoRepositorio, MaterialRepositorio)
import joyas_oscar.vista.VentanaCliente;
import joyas_oscar.vista.VentanaInicio;
import joyas_oscar.vista.VentanaLogin;

public class Aplicacion {

    // 1. Repositorios compartidos (se instancian UNA sola vez)
    private final UsuarioRepositorio usuarios = new UsuarioRepositorio();
    private final ClienteRepositorio clientes = new ClienteRepositorio();
    // Agrega aquí tus otros repositorios cuando existan:
    // private final JoyaRepositorio joyas = new JoyaRepositorio();
    // private final PedidoRepositorio pedidos = new PedidoRepositorio();
    // private final PagoRepositorio pagos = new PagoRepositorio();
    // private final MaterialRepositorio materiales = new MaterialRepositorio();

    // 2. Arranca el programa abriendo el login
    public void iniciar() {
        new VentanaLogin(new LoginControlador(usuarios), this).setVisible(true);
    }

    // 3. Abre tu menú principal (VentanaInicio) pasando el usuario/rol autenticado
    public void abrirInicio(Usuario usuario) {
        VentanaInicio inicio = new VentanaInicio();
        // Si creas un método en VentanaInicio para recibir el usuario/rol, llámalo aquí:
        // inicio.configurarUsuario(usuario);
        inicio.setVisible(true);
    }

    // 4. Un método por cada módulo de tu VentanaInicio
    public void abrirClientes() {
        new VentanaClientes(new ClienteControlador(clientes)).setVisible(true);
    }

    // Ejemplos listos para cuando conectes las demás ventanas:
    // public void abrirJoyas() { ... }
    // public void abrirPedidos() { ... }
    // public void abrirPagos() { ... }
    // public void abrirUsuarios() { ... }
    // public void abrirMaterial() { ... }
}
