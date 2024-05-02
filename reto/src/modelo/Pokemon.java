package modelo;

public class Pokemon {

	private int codigo_pokemon;
	private String nombre;
	private String tipo;
	private String color;
	private int num_evo;
	private boolean legendario;
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
	@Override
	public String toString() {
		return "Pokemon [codigo_pokemon=" + codigo_pokemon + ", nombre=" + nombre + ", tipo=" + tipo + ", color="
				+ color + ", num_evo=" + num_evo + ", legendario=" + legendario + "]";
	}
	
	

	
}
