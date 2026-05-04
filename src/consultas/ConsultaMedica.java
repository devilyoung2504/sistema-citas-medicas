package consultas;

import citas.CitaMedica;
import historias.HistoriaClinica;
import recetas.RecetaMedica;

public abstract class ConsultaMedica {
    private final CitaMedica cita;
    private final HistoriaClinica historiaClinica;
    private RecetaMedica recetaGenerada;

    protected ConsultaMedica(CitaMedica cita, HistoriaClinica historiaClinica) {
        this.cita = cita;
        this.historiaClinica = historiaClinica;
    }

    public final void atender() {
        registrarLlegada();
        iniciarConsulta();
        evaluarPaciente();
        actualizarHistoriaClinica();
        recetaGenerada = generarReceta();
        finalizarConsulta();
    }

    private void registrarLlegada() {
        System.out.println("Registrando llegada del paciente: " + cita.getPaciente().getNombre());
        cita.avanzarEstado();
        cita.mostrarEstado();
    }

    private void iniciarConsulta() {
        System.out.println("Iniciando " + cita.getTipoConsulta().getNombre().toLowerCase());
        cita.avanzarEstado();
        cita.mostrarEstado();
    }

    protected abstract void evaluarPaciente();

    protected abstract void actualizarHistoriaClinica();

    protected abstract RecetaMedica generarReceta();

    private void finalizarConsulta() {
        System.out.println("Finalizando consulta y entregando receta.");
        cita.avanzarEstado();
        cita.mostrarEstado();
    }

    protected CitaMedica getCita() {
        return cita;
    }

    protected HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public RecetaMedica getRecetaGenerada() {
        return recetaGenerada;
    }
}
