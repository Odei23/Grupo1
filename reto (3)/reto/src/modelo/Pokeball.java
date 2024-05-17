package modelo;

public class Pokeball extends Objeto{

	private int ratio;

	
	
	public Pokeball() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Pokeball [ratio=" + ratio + "]" + super.toString();
	}
	
	
	
}