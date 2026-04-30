package state;

public class EstadoFinalizada implements EstadoCita {
    @Override
    public void siguiente(Cita cita) {
        System.out.println("La cita ya finalizo.");
    }

    @Override
    public void cancelar(Cita cita) {
        System.out.println("No se puede cancelar una cita finalizada.");
    }

    @Override
    public String getNombre() {
        return "Finalizada";
    }
}
