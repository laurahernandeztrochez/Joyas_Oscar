
package joyas_oscar.modelo;


public class Material { //Completo, sirve
    
    private int idMaterial;
    private double peso;
    private double stock;
    private String nombre;
    private String tipoMaterial;
    private double precio;
   

    public Material(int idMaterial, double peso, double stock,String nombre, String tipoMaterial, double precio) {
        this.idMaterial = idMaterial;
        this.peso = peso;
        this.stock = stock;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
    }
    
    public Material(int idMaterial,String nombre, String tipoMaterial, double precio) {
        this.idMaterial = idMaterial;
        this.peso = 0;
        this.stock = 0;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
    }
       
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
    
    //Metodo validarStock
    public boolean validarStock(double peso) {
        if(peso>0 && peso <= this.stock){
            return true;
        } else {
            return false;
        }
    }
    
    //Metodo calcularTotal
    public double calcularTotal () {
        double precioTotal = this.peso * this.precio; 
        return precioTotal;
    }
    
    //Metodo registrarMateria
    public boolean registrarMaterial(String nombre, String tipoMaterial, double peso, double precio){
      if (validarStock(peso)) {
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.peso = peso;
        this.precio = precio;
        double precioTotal = calcularTotal();
      return true;
    } else {
          return false;
      }
    }
    
    //Metodo obtenerResumen
    public String obtenerResumen() {
        return "ID: " + idMaterial +
                "Nombre: " + nombre +
                "Tipo: "+tipoMaterial+
                "Peso: "+peso+"g" +
                "Precio/g: "+precio+
                "Precio Total: "+calcularTotal();
    }
    
    public String toString(){
        return "id: "+idMaterial+" Resumen: "+obtenerResumen();
    
}
    
}
    



