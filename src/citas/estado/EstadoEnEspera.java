package citas.estado;

import citas.CitaMedica;

public class EstadoEnEspera implements EstadoCita {
    @Override
    public void avanzar(CitaMedica cita) {
        cita.cambiarEstado(new EstadoEnConsulta());
    }

    @Override
    public void cancelar(CitaMedica cita) {
        cita.cambiarEstado(new EstadoCancelada());
    }

    @Override
    public String getNombre() {
        return "En espera";
    }
}
