
package joyas_oscar.modelo;


public class Material { //Completo, sirve
    
    // Atributos privados del material
    private int idMaterial;
    private double peso;
    private double stock;
    private String nombre;
    private String tipoMaterial;
    private double precio;
   
     // Constructor principal para inicializar todos los datos
    public Material(int idMaterial, double peso, double stock,String nombre, String tipoMaterial, double precio) {
        this.idMaterial = idMaterial;
        this.peso = peso;
        this.stock = stock;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
    }
    // Constructor alternativo (sin peso ni stock, inicializándolos en 0)
    public Material(int idMaterial,String nombre, String tipoMaterial, double precio) {
        this.idMaterial = idMaterial;
        this.peso = 0;
        this.stock = 0;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
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
        double precioTotal = this.peso * this.precio; 
        return precioTotal;
    }
    
    // Método donde si el stock es válido, registra y actualiza los datos del material, y si no, no guarda nada
    public boolean registrarMaterial(String nombre, String tipoMaterial, double peso, double precio){
      if (validarStock(peso)) {  // Llama al método anterior para verificar
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.peso = peso;
        this.precio = precio;
        double precioTotal = calcularTotal();  // Calcula el total
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
    



