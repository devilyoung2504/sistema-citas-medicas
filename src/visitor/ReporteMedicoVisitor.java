package visitor;

public class ReporteMedicoVisitor implements VisitanteMedico {
    @Override
    public void visitar(CitaMedica cita) {
        System.out.println("Reporte cita -> codigo: " + cita.getCodigo()
                + ", paciente: " + cita.getPaciente()
                + ", tipo: " + cita.getTipoConsulta());
    }

    @Override
    public void visitar(HistoriaClinicaResumen historiaClinica) {
        System.out.println("Reporte historia -> paciente: " + historiaClinica.getPaciente()
                + ", diagnostico: " + historiaClinica.getDiagnostico());
    }

    @Override
    public void visitar(RecetaMedica receta) {
        System.out.println("Reporte receta -> medicamento: " + receta.getMedicamento()
                + ", dosis: " + receta.getDosis());
    }
}
