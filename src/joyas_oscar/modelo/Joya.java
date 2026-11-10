
package joyas_oscar.modelo;


public class Joya { //Ya completo, sirve
    
    // atributos basicos de la joya en privado 
    private int idJoya;
    private String nombre;
    private String material;
    private Double precio;
    private int stock;

    public Joya() {
    }
   // constructo, donde nace un objeto 
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
    
    //Método tipo String para unir y devolver la descripción básica de la joya
    public String getDescripcion(){
        return "Nombre: "+nombre+", material: "+material+",precio: "+precio;
    }
    
    //Método para validar que la cantidad que se va a vender sea mayor a 0 y menor o igual al stock disponible
    public boolean validarStock(int cantidad) {
        if(cantidad>0 && cantidad <= this.stock){
            return true;
        } else {
            return false;
        }
        
    }
    
    //Método para validar que la cantidad que se va a vender sea mayor a 0 y menor o igual al stock disponible
    public boolean registrarVenta(int cantidad) {
        if (validarStock(cantidad)) {  // Llama al método anterior
            this.stock -= cantidad;  // Si es true, descuenta la cantidad vendida
            return true;
        }
        return false;     // Si no, retorna falso y no se efectúa la venta
    }
    // Método toString para mostrar toda la información de la joya ordenada
    public String toString () {
        return "id: "+ idJoya + ", Descripcion: " + getDescripcion() + ",Stock: " + getStock();
    }

}
    

