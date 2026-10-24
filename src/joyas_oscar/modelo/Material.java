
package joyas_oscar.modelo;


public class Material {
    
    private int idMaterial;
    private double peso;
    private int stock;
    private double precio;
    private double precioTotal;
    private String nombre;
    private String tipoJoya;
   

    public Material() {
    }

    public Material(int idMaterial, double peso, int stock, double precio, double precioTotal, String nombre, String tipoJOya) {
        this.idMaterial = idMaterial;
        this.peso = peso;
        this.stock = stock;
        this.precio = precio;
        this.precioTotal = precioTotal;
        this.nombre = nombre;
        this.tipoJoya = tipoJoya;
    }
        
    public Material(int idMaterial, String nombre, String tipoJoya, double precio){
        this.idMaterial = idMaterial;
        this.peso = 0;
        this.stock = 0;
        this.precio = precio;
        this.precioTotal = 0;
        this.nombre = nombre;
        this.tipoJoya = tipoJoya;
    
    
    }
    public int getIdJoya() {
        return idMaterial;
    }

    public void setMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double peso() {
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

    public Double getPrecio() {
        return precio ;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getTipoJoya() {
        return tipoJoya;
    }

    public void setTipoJoya(String tipoJoya) {
        this.tipoJoya = tipoJoya;
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
    public boolean registrarMaterial(String nombre, String tipoJoya, double peso, double precio){
      if (validarStock(peso)) {
        this.nombre = nombre;
        this.tipoJoya = tipoJoya;
        this.peso = peso;
        this.precio = precio;
        this.precioTotal = calcularTotal();
      return true;
    } else {
          return false;
      }
    }
    
    //Metodo obtenerResumen
    public String obtenerResumen() {
        return "Nombre: "+nombre+",tipo de joya: "+tipoJoya+", precio total: "+precioTotal;
    }
    
    public String toString(){
        return "id: "+idMaterial+" Resumen: "+obtenerResumen();
    
}
    
}
    



