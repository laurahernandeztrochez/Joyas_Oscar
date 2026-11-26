
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


/**
 * Proporciona conexiones JDBC a la base de datos MySQL de la aplicación.
 */
public class ConexionBD {

    private static final String HOST = configuracion(
            "JOYAS_DB_HOST", "joyas.db.host", "localhost");
    private static final String PUERTO = configuracion(
            "JOYAS_DB_PORT", "joyas.db.port", "3306");
    private static final String BASE_DATOS = configuracion(
            "JOYAS_DB_NAME", "joyas.db.name", "joyasoscar");
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PUERTO
            + "/" + BASE_DATOS;
    private static final String USUARIO = configuracion(
            "JOYAS_DB_USER", "joyas.db.user", "root");
    private static final String CLAVE = configuracion(
            "JOYAS_DB_PASSWORD", "joyas.db.password", "1234");


    private ConexionBD() {
    }

    private static String configuracion(
            String nombreVariable, String nombrePropiedad, String valorPorDefecto) {
        String valor = System.getProperty(nombrePropiedad);
        if (valor != null && !valor.trim().isEmpty()) {
            return valor.trim();
        }
        valor = System.getenv(nombreVariable);
        if (valor == null || valor.trim().isEmpty()) {
            return valorPorDefecto;
        }
        return valor.trim();
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
    
