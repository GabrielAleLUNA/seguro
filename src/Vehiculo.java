import java.time.LocalDate;

public class Vehiculo {
    private String dominio;
    private double montoCompra;
    private int añoFabricacion;

    public Vehiculo(String dominio, double montoCompra, int añoFabricacion) {
        this.dominio = dominio;
        this.montoCompra = montoCompra;
        this.añoFabricacion = añoFabricacion;
    }

    public String getDominio() {
        return dominio;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }
    
    public int getAntiguedadAuto() {
        return LocalDate.now().getYear() - añoFabricacion;
    }


}
