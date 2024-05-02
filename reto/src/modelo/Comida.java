package modelo;

public class Comida {

	
	private String nombre;
	private float precioComida;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecioComida() {
		return precioComida;
	}
	public void setPrecioComida(float precioComida) {
		this.precioComida = precioComida;
	}
	@Override
	public String toString() {
		return "Comida [nombre=" + nombre + ", precioComida=" + precioComida + "]";
	}
	
	
}
