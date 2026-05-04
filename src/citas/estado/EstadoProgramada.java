package citas.estado;

import citas.CitaMedica;

public class EstadoProgramada implements EstadoCita {
    @Override
    public void avanzar(CitaMedica cita) {
        cita.cambiarEstado(new EstadoEnEspera());
    }

    @Override
    public void cancelar(CitaMedica cita) {
        cita.cambiarEstado(new EstadoCancelada());
    }

    @Override
    public String getNombre() {
        return "Programada";
    }
}
