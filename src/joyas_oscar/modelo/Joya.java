
package joyas_oscar.modelo;


public class Joya { //Ya completo, sirve

    private int idJoya;
    private String nombre;
    private String material;
    private Double precio;
    private int stock;

    public Joya() {
    }

    public Joya(int idJoya, String nombre, String material, Double precio, int stock) {
        this.idJoya = idJoya;
        this.nombre = nombre;
        this.material = material;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdJoya() {
        return idJoya;
    }

    public void setIdJoya(int idJoya) {
        this.idJoya = idJoya;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPrecio() {
        return precio ;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Metodo obtenerDescripcion
    public String getDescripcion(){
        return "Nombre: "+nombre+", material: "+material+",precio: "+precio;
    }
    
    //Metodo validarStock
    public boolean validarStock(int cantidad) {
        if(cantidad>0 && cantidad <= this.stock){
            return true;
        } else {
            return false;
        }
        
    }
    
    //Metodo registrarVenta
    public boolean registrarVenta(int cantidad) {
        if (validarStock(cantidad)) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }
    
    public String toString () {
        return "id: "+ idJoya + ", Descripcion: " + getDescripcion() + ",Stock: " + getStock();
    }

}
    

