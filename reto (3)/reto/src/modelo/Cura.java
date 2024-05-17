package modelo;

public class Cura extends Objeto {

    private int cantidad_cura;

    public Cura() {
        super();
    }

    public int getCantidad_cura() {
        return cantidad_cura;
    }

    public void setCantidad_cura(int cantidad_cura) {
        this.cantidad_cura = cantidad_cura;
    }

    @Override
    public String toString() {
        return "Cura [cantidad_cura=" + cantidad_cura + "]" + super.toString();
    }
}
