package modelo;

public class Cura {

	
	private String nombre;
	private float precioCura;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecioCura() {
		return precioCura;
	}
	public void setPrecioCura(float precioCura) {
		this.precioCura = precioCura;
	}
	@Override
	public String toString() {
		return "Cura [nombre=" + nombre + ", precioCura=" + precioCura + "]";
	}
	
	
	
}
