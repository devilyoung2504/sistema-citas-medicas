package template;

public class ConsultaInterna extends ConsultaMedica {
    public ConsultaInterna(String paciente, String codigoCita) {
        super(paciente, codigoCita);
    }

    @Override
    protected void evaluarPaciente() {
        System.out.println("Evaluacion general de medicina interna para " + getPaciente());
    }

    @Override
    protected void generarReceta() {
        System.out.println("Generando receta de control general.");
    }
}
