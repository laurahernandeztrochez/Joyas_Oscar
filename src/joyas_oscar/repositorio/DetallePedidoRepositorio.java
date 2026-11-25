
package joyas_oscar.repositorio;
import joyas_oscar.modelo.DetallePedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    
public class DetallePedidoRepositorio {

    public void guardar(Connection conn, DetallePedido d) throws SQLException {
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_joya, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, d.getPedido().getIdPedido());
            ps.setInt(2, d.getJoya().getIdJoya());
            ps.setInt(3, d. getCantidad());
            ps.setDouble(4, d.getPrecioUnitario());
            ps.setDouble(5, d.calcularSubtotal()); // cantidad * precio
            ps.executeUpdate();
        }
    }
}
    

