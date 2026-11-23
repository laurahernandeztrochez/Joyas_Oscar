
package joyas_oscar.Pruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import joyas_oscar.util.ConexionBD;


/**
 * Programa de prueba que comprueba la conexión a MySQL y consulta
 * la cantidad de joyas activas.
 */
public class PruebaConexion {
     public static void main(String[] args) {

        
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement instruccion = conexion.createStatement();
             ResultSet resultado = instruccion.executeQuery(
                     "SELECT COUNT(*) AS total FROM joyas WHERE activo = TRUE")) {

           
            System.out.println("¡Conexión exitosa!");
            System.out.println("Base de datos: " + conexion.getCatalog());   // joyasoscar

          
            if (resultado.next()) {
                System.out.println(" Joyas activos en MySQL: " + resultado.getInt("total"));   // 3
            }

        } catch (SQLException e) {
          
            System.out.println("No se pudo conectar a la base de datos.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }
}
