package state;

public class EstadoProgramada implements EstadoCita {
    @Override
    public void siguiente(Cita cita) {
        cita.setEstado(new EstadoEnEspera());
    }

    @Override
    public void cancelar(Cita cita) {
        cita.setEstado(new EstadoCancelada());
    }

    @Override
    public String getNombre() {
        return "Programada";
    }
}
