package modelo;

public class Objeto {
	private String codigo_objeto;
	private int precio_obejto;
	private String tipo_objeto;
	private String stock;
	public String getCodigo_objeto() {
		return codigo_objeto;
	}
	public void setCodigo_objeto(String codigo_objeto) {
		this.codigo_objeto = codigo_objeto;
	}
	public int getPrecio_obejto() {
		return precio_obejto;
	}
	public void setPrecio_obejto(int precio_obejto) {
		this.precio_obejto = precio_obejto;
	}
	public String getTipo_objeto() {
		return tipo_objeto;
	}
	public void setTipo_objeto(String tipo_objeto) {
		this.tipo_objeto = tipo_objeto;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Objeto [codigo_objeto=" + codigo_objeto + ", precio_obejto=" + precio_obejto + ", tipo_objeto="
				+ tipo_objeto + ", stock=" + stock + "]";
	}
}