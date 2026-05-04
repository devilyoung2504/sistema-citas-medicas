package citas.estado;

import citas.CitaMedica;

public class EstadoCancelada implements EstadoCita {
    @Override
    public void avanzar(CitaMedica cita) {
        System.out.println("La cita esta cancelada y no puede avanzar.");
    }

    @Override
    public void cancelar(CitaMedica cita) {
        System.out.println("La cita ya fue cancelada.");
    }

    @Override
    public String getNombre() {
        return "Cancelada";
    }
}
