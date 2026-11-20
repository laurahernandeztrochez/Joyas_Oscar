
/*
 * =========================================================================
 *  CLASE: ConexionBD                      PAQUETE: Joyas_oscar.util
 * =========================================================================
 *
 *  ¿PARA QUÉ SIRVE?
 *  Permite conectar el programa de java con la base de datos en MySQL
 *    con esto permite que todo lo que se ingrese quede guardado directo a la base de datos
 *
 *
 *  ¿QUÉ DEBE EXISTIR ANTES DE CREAR ESTA CLASE?
 *    - MySQL Server instalado y en ejecución (servicio MySQL80).
 *    - La base de datos joyasoscar, creada con los scripts 01 y 02.
 *    - El .jar de Connector/J agregado a Libraries.
 */

package joyas_oscar.util;

import java.sql.Connection;     
import java.sql.DriverManager;   
import java.sql.SQLException;    


public class ConexionBD {
     
    private static final String URL = "jdbc:mysql://localhost:3306/joyasoscar";
    private static final String USUARIO = "root";          
    private static final String CLAVE = "1234";    


    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
    
