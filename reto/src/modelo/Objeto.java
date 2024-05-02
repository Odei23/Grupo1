package modelo;

public class Objeto {

	
	private String nombre;
	private String tipo_objeto;
	private int stock;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo_objeto() {
		return tipo_objeto;
	}
	public void setTipo_objeto(String tipo_objeto) {
		this.tipo_objeto = tipo_objeto;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", tipo_objeto=" + tipo_objeto + ", stock=" + stock + "]";
	}
	
	
}
