package joyas_oscar;

import joyas_oscar.controlador.LoginControlador;
import joyas_oscar.modelo.Usuario;
import joyas_oscar.repositorio.UsuarioRepositorio;
import joyas_oscar.vista.VentanaCliente;
import joyas_oscar.vista.VentanaInicio;
import joyas_oscar.vista.VentanaJoya;
import joyas_oscar.vista.VentanaLogin;
import joyas_oscar.vista.VentanaUsuario;
import joyas_oscar.vista.VentanaMaterial;
import joyas_oscar.vista.VentanaPedido;
import joyas_oscar.vista.VentanaPagos;
import joyas_oscar.controlador.ClienteControlador;
import joyas_oscar.controlador.MaterialControlador;
import joyas_oscar.repositorio.ClienteRepositorio;
import joyas_oscar.repositorio.MaterialRepositorio;
import joyas_oscar.repositorio.JoyaRepositorio;
import joyas_oscar.controlador.JoyaControlador;
import joyas_oscar.controlador.UsuarioControlador;
import joyas_oscar.controlador.PedidoControlador;
import joyas_oscar.repositorio.PedidoRepositorio;
import joyas_oscar.repositorio.PagoRepositorio;
import joyas_oscar.controlador.PagoControlador;

/**
 * Coordina la aplicación: crea los repositorios y controladores necesarios
 * y abre las ventanas de inicio de sesión, menú y módulos.
 */
public class Aplicacion {

    private UsuarioRepositorio usuarios = new UsuarioRepositorio();
    private ClienteRepositorio clientes = new ClienteRepositorio();
    private MaterialRepositorio materiales = new MaterialRepositorio();
    private JoyaRepositorio joyas = new JoyaRepositorio();
    private PedidoRepositorio pedidos = new PedidoRepositorio();
    private PagoRepositorio pagos = new PagoRepositorio();
     
    
    public void iniciar() {
        new VentanaLogin(new LoginControlador(usuarios), this).setVisible(true);
    }

 public void abrirPrincipal(Usuario usuario) {
    new VentanaInicio(this, usuario).setVisible(true);
}
 
    public void abrirJoya() {
       new VentanaJoya(new JoyaControlador(joyas)).setVisible(true);
    }

   public void abrirCliente() {
    new VentanaCliente(new ClienteControlador(clientes)).setVisible(true);
}

    public void abrirUsuario() {
      new VentanaUsuario(new UsuarioControlador(usuarios)).setVisible(true);
    }

    public void abrirMaterial() {
        new VentanaMaterial(new MaterialControlador(materiales)).setVisible(true);
    }
    
    public void abrirPedido() {
        new VentanaPedido(new PedidoControlador(pedidos)).setVisible(true);
    }
    
    // public void abrirPago() {
    //    new VentanaPagos(new PagoControlador(pagos)).setVisible(true);
    //}
    
    public PagoRepositorio getPagos() {
    return pagos;
}

public PedidoRepositorio getPedidos() {
    return pedidos;
}
    
}