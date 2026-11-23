
package joyas_oscar.modelo;


/**
 * Representa un material utilizado por el negocio, incluyendo su tipo,
 * peso, precio, total, existencias y estado.
 */
public class Material { //Completo, sirve
    
    // Atributos privados del material
    private int idMaterial;
    private double peso;
    private int stock;
    private String nombre;
    private String tipoMaterial;
    private double precio;
    private double total;
    private boolean activo;
   
     // Constructor principal para inicializar todos los datos
    public Material(int idMaterial, double peso, int stock,String nombre, String tipoMaterial, double precio, boolean activo) {
        this(idMaterial, peso, stock, nombre, tipoMaterial, precio, peso * precio, activo);
    }

    public Material(int idMaterial, double peso, int stock, String nombre,
            String tipoMaterial, double precio, double total, boolean activo) {
        this.idMaterial = idMaterial;
        this.peso = peso;
        this.stock = stock;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
        this.total = total;
        this.activo = activo;
    }
    // Constructor alternativo (sin peso ni stock, inicializándolos en 0)
    public Material(int idMaterial,String nombre, String tipoMaterial, double precio) {
        this.idMaterial = idMaterial;
        this.peso = 0;
        this.stock = 0;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
        this.total = 0;
        this.activo = true;
    }
    // Método para obtener el ID del material   
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    
    public double getPrecio () {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
        public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo=activo;
    }
    
    
    
    // Método para validar que el peso sea mayor a 0 y menor o igual al stock disponible
    public boolean validarStock(double peso) {
        if(peso>0 && peso <= this.stock){
            return true;
        } else {
            return false;
        }
    }
    
    // Método para calcular el precio total multiplicando el peso por el precio unitario
    public double calcularTotal () {
        this.total = this.peso * this.precio;
        return this.total;
    }
    
    // Método donde si el stock es válido, registra y actualiza los datos del material, y si no, no guarda nada
    public boolean registrarMaterial(String nombre, String tipoMaterial, double peso, double precio){
      if (validarStock(peso)) {  // Llama al método anterior para verificar
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.peso = peso;
        this.precio = precio;
        calcularTotal();
      return true;
    } else {
          return false;  // Si no, retorna falso y no guarda
      }
    }
    
    // Método para obtener un resumen completo con los datos y el total calculado del material
    public String obtenerResumen() {
        return "ID: " + idMaterial +
                ", Nombre: " + nombre +
                ", Tipo: "+tipoMaterial+
                ", Peso: "+peso+"g" +
                ", Precio/g: "+precio+
                ", Precio Total: "+calcularTotal();
    }
    // Método toString para mostrar el resumen del material en un solo texto
    public String toString(){
        return  "Resumen: "+obtenerResumen();
    
}
    
}
    



