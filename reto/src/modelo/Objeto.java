package modelo;

public class Objeto {

    private String codigo_objeto;
    private String nombre_objeto;
    private int stock_objeto;
    private int precio_objeto;
    private String imagen_objeto;

    public String getCodigo_Objeto() {
        return codigo_objeto;
    }

    public void setCodigo_Objeto(String codigo_objeto) {
        this.codigo_objeto = codigo_objeto; // Corrección aquí
    }

    public String getNombre_objeto() {
        return nombre_objeto;
    }

    public void setNombre_objeto(String nombre_objeto) {
        this.nombre_objeto = nombre_objeto;
    }

    public int getStock_objeto() {
        return stock_objeto;
    }

    public void setStock_objeto(int stock_objeto) {
        this.stock_objeto = stock_objeto;
    }

    public int getPrecio_objeto() {
        return precio_objeto;
    }

    public void setPrecio_objeto(int precio_objeto) {
        this.precio_objeto = precio_objeto;
    }

    public String getImagen_objeto() {
        return imagen_objeto;
    }

    public void setImagen_objeto(String imagen_objeto) {
        this.imagen_objeto = imagen_objeto;
    }

    @Override
    public String toString() {
        return "Objeto [Codigo_Objeto=" + codigo_objeto + ", nombre_objeto=" + nombre_objeto + ", stock_objeto=" + stock_objeto + ", precio_objeto="
                + precio_objeto + ", imagen_objeto=" + imagen_objeto + "]";
    }
}
