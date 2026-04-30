package state;

public class EstadoCancelada implements EstadoCita {
    @Override
    public void siguiente(Cita cita) {
        System.out.println("La cita esta cancelada.");
    }

    @Override
    public void cancelar(Cita cita) {
        System.out.println("La cita ya fue cancelada.");
    }

    @Override
    public String getNombre() {
        return "Cancelada";
    }
}
