import java.time.LocalDate;


public class Poliza {
    private Cliente cliente;
    private double montoAsegurado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Vehiculo vehiculo;
    private double costo;
    private String estaVigente;

    //contructor Auto
    public Poliza(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculo = vehiculo;
        this.montoAsegurado = calculoMontoAseguradoAuto();
        this.costo = calcularCostoAuto();
        this.estaVigente = estaVigente();

    }
    //Contructor Vida
    public Poliza(Cliente cliente, double montoAsegurado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.montoAsegurado = montoAsegurado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = calcularCostoVida();
        }
        
        private double calcularCostoVida() {
            if (cliente.getEdad() < 35) {
                return montoAsegurado * 0.05;        
            } else {
                return montoAsegurado * 0.1;   
            }
        }
        
        private double calcularCostoAuto() {
            if (cliente.getEdad() < 30) {
               costo = montoAsegurado * 0.2;        
            } else {
                costo = montoAsegurado * 0.1;             
            }
            return costo;
        }
       
        private double calculoMontoAseguradoAuto(){
            montoAsegurado = vehiculo.getMontoCompra() - (vehiculo.getMontoCompra() * ( (vehiculo.getAntiguedadAuto() * 0.05)));
            return montoAsegurado;
        }

        public String estaVigente(){
            if (LocalDate.now().isAfter(fechaFin)){
                return "NO";
            } else {
                return "SI";
            }
        }        

        public Cliente getCliente() {
            return cliente;
        }

        public double getMontoAsegurado() {
            return montoAsegurado;
        }

        public double getCosto() {
            return costo;
        }

        public LocalDate getFechaInicio() {
            return fechaInicio;
        }

        public LocalDate getFechaFin() {
            return fechaFin;
        }
        public void setCliente(Cliente cliente2) {
            this.cliente = cliente2;
        }
        public Vehiculo getVehiculo() {
            return vehiculo;
        }   
    }

