package modelo;

public class Cura {

	
	private String nombre_cura;
	private float codigo_objeto;
	private String imagen_cura;
	public String getNombre_cura() {
		return nombre_cura;
	}
	public void setNombre_cura(String nombre_cura) {
		this.nombre_cura = nombre_cura;
	}
	public float getCodigo_objeto() {
		return codigo_objeto;
	}
	public void setCodigo_objeto(float codigo_objeto) {
		this.codigo_objeto = codigo_objeto;
	}
	public String getImagen_cura() {
		return imagen_cura;
	}
	public void setImagen_cura(String imagen_cura) {
		this.imagen_cura = imagen_cura;
	}
	@Override
	public String toString() {
		return "Cura [nombre_cura=" + nombre_cura + ", codigo_objeto=" + codigo_objeto + ", imagen_cura=" + imagen_cura
				+ "]";
	}
	
	
	
	
	
}
