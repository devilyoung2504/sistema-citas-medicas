package template;

public class ConsultaExterna extends ConsultaMedica {
    public ConsultaExterna(String paciente, String codigoCita) {
        super(paciente, codigoCita);
    }

    @Override
    protected void evaluarPaciente() {
        System.out.println("Evaluacion ambulatoria y revision de sintomas para " + getPaciente());
    }

    @Override
    protected void generarReceta() {
        System.out.println("Generando formula para manejo en casa.");
    }
}
