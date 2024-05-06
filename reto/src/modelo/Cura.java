package modelo;

public class Cura {

	
	private String codigo_objeto;
	private int precio_cura;
	private int stock_cura;
	private String nombre_cura;
	private String imagen_cura;
	public String getCodigo_objeto() {
		return codigo_objeto;
	}
	public void setCodigo_objeto(String codigo_objeto) {
		this.codigo_objeto = codigo_objeto;
	}
	public int getPrecio_cura() {
		return precio_cura;
	}
	public void setPrecio_cura(int precio_cura) {
		this.precio_cura = precio_cura;
	}
	public int getStock_cura() {
		return stock_cura;
	}
	public void setStock_cura(int stock_cura) {
		this.stock_cura = stock_cura;
	}
	public String getNombre_cura() {
		return nombre_cura;
	}
	public void setNombre_cura(String nombre_cura) {
		this.nombre_cura = nombre_cura;
	}
	public String getImagen_cura() {
		return imagen_cura;
	}
	public void setImagen_cura(String imagen_cura) {
		this.imagen_cura = imagen_cura;
	}
	@Override
	public String toString() {
		return "Cura [codigo_objeto=" + codigo_objeto + ", precio_cura=" + precio_cura + ", stock_cura=" + stock_cura
				+ ", nombre_cura=" + nombre_cura + ", imagen_cura=" + imagen_cura + "]";
	}
	
	
	
	
	
}
