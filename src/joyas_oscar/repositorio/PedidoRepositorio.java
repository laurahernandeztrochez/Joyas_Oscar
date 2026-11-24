
package joyas_oscar.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import joyas_oscar.modelo.Pedido;
import joyas_oscar.util.ConexionBD;

public class PedidoRepositorio {
    
      
    private static final String SELECT_BASE =
            "SELECT id_pedido, estado, direccion, fecha_pedido, total, id_cliente FROM pedidos ";


    // =====================================================================
    // C: CREATE -> guardar
    // =====================================================================
    public void guardar(Pedido pedido) {
        String sql = "INSERT INTO pedidos (estado, direccion, fecha_pedido, total,  id_cliente) "
                   + "VALUES (?, ?, ?, ?, ?)";
        java.sql.Date fecha = convertirFecha(pedido.getFecha());

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            llenarDatos(ps, pedido, fecha);
            ps.executeUpdate();

            try (ResultSet llaves = ps.getGeneratedKeys()) {
                if (llaves.next()) {
                    pedido.setIdPedido(llaves.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el pedido: " + e.getMessage(), e);
        }
    }

    private void llenarDatos(PreparedStatement ps, Pedido pedido, java.sql.Date fecha) throws SQLException {
        ps.setString(1, pedido.getEstado());
        ps.setString(2, pedido.getDireccion());
        ps.setDate(3, fecha);
        ps.setDouble(4, pedido.getTotal());
        ps.setInt(5, pedido.getCliente().getIdCliente());
    }

    private java.sql.Date convertirFecha(String fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha del pedido es obligatoria y debe usar el formato yyyy-MM-dd");
        }

        try {
            return java.sql.Date.valueOf(LocalDate.parse(fecha));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "La fecha del pedido debe usar el formato yyyy-MM-dd", e);
        }
    }
}