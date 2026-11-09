/*
 * =========================================================================
 *  CLASE: Seguridad                       PAQUETE: joyas_oscar.util
 * =========================================================================
 *
 * Seguridad sirve para que hashSHA256 (que seria la contraseña) devuelva en vez de 
 * la contraseña visible como 1234, se vuelva un codigo largo de 64 letras y numeros, por mayor seguridad
 * de esta manera alguien no podria robar la base de datos de forma tan facil y no ver las contraseñas de forma tan clara
 *
 * ¿Con quien se conecta?
 * Esta conectado con Usuario de forma dependiente
 *
 * ¿QUÉ DEBE EXISTIR ANTES DE CREAR ESTA CLASE?
 * Solo debe existir el paquete util donde se pueda crear esta clase seguridad dentro de util
 *
 *
*/
package joyas_oscar.util;

import java.nio.charset.StandardCharsets;    
import java.security.MessageDigest;           
import java.security.NoSuchAlgorithmException; 

public class Seguridad {
    
     public static String hashSHA256(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");          
            byte[] bytes = md.digest(texto.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();                    
            for (byte b : bytes) {
                hex.append(String.format("%02x", b));                    
            }
            return hex.toString();                                            
        } catch (NoSuchAlgorithmException e) {
          
            throw new RuntimeException("SHA-256 no está disponible", e);
        }
    }
    
}
