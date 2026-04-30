package state;

public class EstadoEnConsulta implements EstadoCita {
    @Override
    public void siguiente(Cita cita) {
        cita.setEstado(new EstadoFinalizada());
    }

    @Override
    public void cancelar(Cita cita) {
        System.out.println("No se puede cancelar una cita que ya esta en consulta.");
    }

    @Override
    public String getNombre() {
        return "En consulta";
    }
}
