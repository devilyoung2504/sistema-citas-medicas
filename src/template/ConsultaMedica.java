package template;

public abstract class ConsultaMedica {
    private final String paciente;
    private final String codigoCita;

    protected ConsultaMedica(String paciente, String codigoCita) {
        this.paciente = paciente;
        this.codigoCita = codigoCita;
    }

    public final void atenderConsulta() {
        registrarPaciente();
        validarCita();
        evaluarPaciente();
        crearHistoriaClinica();
        generarReceta();
        finalizarConsulta();
    }

    protected void registrarPaciente() {
        System.out.println("Registrando paciente: " + paciente);
    }

    protected void validarCita() {
        System.out.println("Validando cita medica: " + codigoCita);
    }

    protected abstract void evaluarPaciente();

    protected void crearHistoriaClinica() {
        System.out.println("Creando historia clinica para " + paciente);
    }

    protected abstract void generarReceta();

    protected void finalizarConsulta() {
        System.out.println("Consulta finalizada para " + paciente);
    }

    protected String getPaciente() {
        return paciente;
    }
}
