package visitor;

public class HistoriaClinicaResumen implements ElementoMedico {
    private final String paciente;
    private final String diagnostico;

    public HistoriaClinicaResumen(String paciente, String diagnostico) {
        this.paciente = paciente;
        this.diagnostico = diagnostico;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public void aceptar(VisitanteMedico visitante) {
        visitante.visitar(this);
    }
}
