package citas.estado;

import citas.CitaMedica;

public class EstadoEnConsulta implements EstadoCita {
    @Override
    public void avanzar(CitaMedica cita) {
        cita.cambiarEstado(new EstadoFinalizada());
    }

    @Override
    public void cancelar(CitaMedica cita) {
        System.out.println("No se puede cancelar una cita que ya esta en consulta.");
    }

    @Override
    public String getNombre() {
        return "En consulta";
    }
}
