package modelo;

public class Pokeballs {

	
	private String nombre_pokeballs;
	private float codigo_objeto;
	private String imagen_pokeballs;
	public String getNombre_pokeballs() {
		return nombre_pokeballs;
	}
	public void setNombre_pokeballs(String nombre_pokeballs) {
		this.nombre_pokeballs = nombre_pokeballs;
	}
	public float getCodigo_objeto() {
		return codigo_objeto;
	}
	public void setCodigo_objeto(float codigo_objeto) {
		this.codigo_objeto = codigo_objeto;
	}
	public String getImagen_pokeballs() {
		return imagen_pokeballs;
	}
	public void setImagen_pokeballs(String imagen_pokeballs) {
		this.imagen_pokeballs = imagen_pokeballs;
	}
	@Override
	public String toString() {
		return "Pokeballs [nombre_pokeballs=" + nombre_pokeballs + ", codigo_objeto=" + codigo_objeto
				+ ", imagen_pokeballs=" + imagen_pokeballs + "]";
	}
	
	
	
	
	
}
