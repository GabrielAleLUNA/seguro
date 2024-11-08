import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate; 

public class Aseguradora {
    private String nombre;
    private List<Poliza> polizas;
    private List<Cliente> clientes;

    public Aseguradora(String nombre) {
        this.nombre = nombre;
        polizas = new ArrayList<>();
        clientes = new ArrayList<>();

    }

    public Poliza asegurarVehiculo(Cliente cliente, Vehiculo vehiculo, LocalDate fechainicio, LocalDate fechafin) {
        Poliza poliza = new Poliza(cliente, vehiculo, fechainicio, fechafin);
        polizas.add(poliza);
        return poliza;
        
    }

    public Poliza asegurarVida(Cliente cliente, double montoAsegurado, LocalDate fechainicio, LocalDate fechafin) {
        Poliza poliza = new Poliza(cliente, montoAsegurado, fechainicio, fechafin);
        polizas.add(poliza);
        return poliza;
        
    }

    public void mostrarPolizas() {
        for (Poliza poliza : polizas) {
            System.out.println("\n--- Poliza ---"); 
            System.out.println(poliza.getCliente().toString());
            System.out.println("Monto asegurado: " + poliza.getMontoAsegurado());
            System.out.println("Costo Anual: " + poliza.getCosto());
            System.out.println("Vigencia desde: " + poliza.getFechaInicio());
            System.out.println("Vigencia hasta: " + poliza.getFechaFin());
            System.out.println("Vigente: " + poliza.estaVigente());
            if (poliza.getVehiculo() != null) {
                System.out.println("--- Vehiculo ---");
                System.out.println("Dominio: " + poliza.getVehiculo().getDominio());
                System.out.println("Año Fabricacion: " + poliza.getVehiculo().getAñoFabricacion());
                System.out.println("Monto Compra: " + poliza.getVehiculo().getMontoCompra());
            } else {
                System.out.println("Tipo de Poliza: Vida");
            }
        }    
            
        
    }

    public void transferirPoliza(Poliza poliza, Cliente cliente) {
        if(poliza.estaVigente().equals("SI")){
            poliza.setCliente(cliente);
            System.out.println("Poliza transferida");  
        } else { 
            System.out.println("No se puede transferir poliza vencida");
        }    
    }
}
