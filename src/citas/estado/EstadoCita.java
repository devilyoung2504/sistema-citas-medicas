package citas.estado;

import citas.CitaMedica;

public interface EstadoCita {
    void avanzar(CitaMedica cita);

    void cancelar(CitaMedica cita);

    String getNombre();
}
