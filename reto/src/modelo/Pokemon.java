package modelo;

public class Pokemon {

    private int codigo_pokemon;
    private String nombre;
    private String tipo;
    private String color;
    private int num_evo;
    private boolean legendario;
    private int precio_pokemon;
    private int stock_pokemon;
    private String imagen_pokemon;
    private boolean comprado; // Nuevo atributo para indicar si el Pokémon ha sido comprado

    public int getCodigo_pokemon() {
        return codigo_pokemon;
    }

    public void setCodigo_pokemon(int codigo_pokemon) {
        this.codigo_pokemon = codigo_pokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum_evo() {
        return num_evo;
    }

    public void setNum_evo(int num_evo) {
        this.num_evo = num_evo;
    }

    public boolean isLegendario() {
        return legendario;
    }

    public void setLegendario(boolean legendario) {
        this.legendario = legendario;
    }

    public int getPrecioPokemon() {
        return precio_pokemon;
    }

    public void setPrecioPokemon(int precio_pokemon) {
        this.precio_pokemon = precio_pokemon;
    }

    public int getStock_pokemon() {
        return stock_pokemon;
    }

    public void setStock_pokemon(int stock_pokemon) {
        this.stock_pokemon = stock_pokemon;
    }

    public String getImagen_pokemon() {
        return imagen_pokemon;
    }

    public void setImagen_pokemon(String imagen_pokemon) {
        this.imagen_pokemon = imagen_pokemon;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @Override
    public String toString() {
        return "Pokemon [codigo_pokemon=" + codigo_pokemon + ", nombre=" + nombre + ", tipo=" + tipo + ", color="
                + color + ", num_evo=" + num_evo + ", legendario=" + legendario + ", precio_pokemon=" + precio_pokemon
                + ", stock_pokemon=" + stock_pokemon + ", imagen_pokemon=" + imagen_pokemon + ", comprado=" + comprado
                + "]";
    }
}
