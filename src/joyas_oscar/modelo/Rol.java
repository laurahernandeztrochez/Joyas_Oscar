
package joyas_oscar.modelo;
/* =========================================================================
   CLASE: Rol                        PAQUETE: ministore.modelo
  =========================================================================

  Sirve para representar al usuario, como empleado o administrador de joyas oscar
  Existen los roles de: administrador, joyero, y dependiente/vendedor
  Se conecta con Usuario mediante asociacion, con el repositorioUsuario y la ventanaUsuario
  
 */

public class Rol {
    
    private int idRol; //Identifica el rol
    private String nombre; //El tipo de rol, administradoor,, joyero o vendedor
    
    //Constructor donde nace el objeto
    public Rol (int idRol, String nombre) {
        //Asigna
        this.idRol = idRol; 
        this.nombre = nombre;
    }
    
    //Gets, sin set
    public int getIdRol() {
        return idRol;
    }
    
    public String getNombre() {
        return nombre;
    }
   
    //No existen los set de manera aporposito porque los roles deben ser fijos
    //con set cualquiera podria cambiar los roles, la idea es que los roles no puedan cambiarse, solamente seleccionarse
    //y no ser ezcritos por el usuario
}
