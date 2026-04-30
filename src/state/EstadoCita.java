package state;

public interface EstadoCita {
    void siguiente(Cita cita);

    void cancelar(Cita cita);

    String getNombre();
}
