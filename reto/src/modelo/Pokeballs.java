package modelo;

public class Pokeballs {

	
	private String nombre;
	private float precioPokeballs;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecioPokeballs() {
		return precioPokeballs;
	}
	public void setPrecioPokeballs(float precioPokeballs) {
		this.precioPokeballs = precioPokeballs;
	}
	@Override
	public String toString() {
		return "Cura [nombre=" + nombre + ", precioPokeballs=" + precioPokeballs + "]";
	}
	
	
	
}
