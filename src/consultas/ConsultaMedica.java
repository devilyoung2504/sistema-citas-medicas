package consultas;

import citas.Cita;
import historias.HistoriaClinica;

public abstract class ConsultaMedica {
    protected final Cita cita;
    protected final HistoriaClinica historia;

    public ConsultaMedica(Cita cita, HistoriaClinica historia) {
        this.cita = cita;
        this.historia = historia;
    }

    public final void atender() {
        registrar();
        diagnosticar();
        recetar();
        finalizar();
    }

    private void registrar() {
        System.out.println("Registrando paciente: " + cita.getPaciente().getNombre());
    }

    protected abstract void diagnosticar();

    protected abstract void recetar();

    private void finalizar() {
        cita.avanzar();
        cita.mostrarEstado();
    }
}
