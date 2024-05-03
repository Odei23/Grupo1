package modelo;

public class Comida {

	
	private String nombre_comida;
	private float codigo_objeto;
	private String imagen_comida;
	public String getNombre_comida() {
		return nombre_comida;
	}
	public void setNombre_comida(String nombre_comida) {
		this.nombre_comida = nombre_comida;
	}
	public float getCodigo_objeto() {
		return codigo_objeto;
	}
	public void setCodigo_objeto(float codigo_objeto) {
		this.codigo_objeto = codigo_objeto;
	}
	public String getImagen_comida() {
		return imagen_comida;
	}
	public void setImagen_comida(String imagen_comida) {
		this.imagen_comida = imagen_comida;
	}
	@Override
	public String toString() {
		return "Comida [nombre_comida=" + nombre_comida + ", codigo_objeto=" + codigo_objeto + ", imagen_comida="
				+ imagen_comida + "]";
	}

	
	
	
}
