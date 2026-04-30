package state;

public class EstadoEnEspera implements EstadoCita {
    @Override
    public void siguiente(Cita cita) {
        cita.setEstado(new EstadoEnConsulta());
    }

    @Override
    public void cancelar(Cita cita) {
        cita.setEstado(new EstadoCancelada());
    }

    @Override
    public String getNombre() {
        return "En espera";
    }
}
