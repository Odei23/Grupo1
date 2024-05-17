package modelo;

public class Comida extends Objeto{

    private String efecto;

    public Comida() {
        super();
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    @Override
    public String toString() {
        return "Comida [efecto=" + efecto + "]" + super.toString();
    }
}
