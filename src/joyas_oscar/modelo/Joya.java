
package joyas_oscar.modelo;


public class Joya {

    private int idJoya;
    private String nombre;
    private String material;
    private Double precio;
    private String stock;

    public Joya() {
    }

    public Joya(int idJoya, String nombre, String material, Double precio, String stock) {
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
    

