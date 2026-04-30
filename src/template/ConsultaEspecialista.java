package template;

public class ConsultaEspecialista extends ConsultaMedica {
    private final String especialidad;

    public ConsultaEspecialista(String paciente, String codigoCita, String especialidad) {
        super(paciente, codigoCita);
        this.especialidad = especialidad;
    }

    @Override
    protected void evaluarPaciente() {
        System.out.println("Evaluacion especializada de " + especialidad + " para " + getPaciente());
    }

    @Override
    protected void generarReceta() {
        System.out.println("Generando receta especializada de " + especialidad + ".");
    }
}
