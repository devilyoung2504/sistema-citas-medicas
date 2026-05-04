package citas.estado;

import citas.CitaMedica;

public class EstadoFinalizada implements EstadoCita {
    @Override
    public void avanzar(CitaMedica cita) {
        System.out.println("La cita ya se encuentra finalizada.");
    }

    @Override
    public void cancelar(CitaMedica cita) {
        System.out.println("No se puede cancelar una cita finalizada.");
    }

    @Override
    public String getNombre() {
        return "Finalizada";
    }
}
