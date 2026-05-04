package reportes;

import citas.CitaMedica;
import historias.HistoriaClinica;
import recetas.RecetaMedica;

public class ReporteMedicoVisitor implements VisitanteReporte {
    @Override
    public void visitar(CitaMedica cita) {
        System.out.println("Reporte cita: " + cita.getCodigo()
                + " | Paciente: " + cita.getPaciente().getNombre()
                + " | Tipo: " + cita.getTipoConsulta().getNombre()
                + " | Estado: " + cita.getNombreEstado());
    }

    @Override
    public void visitar(HistoriaClinica historiaClinica) {
        System.out.println("Reporte historia: " + historiaClinica.getPaciente().getNombre()
                + " | Diagnostico: " + historiaClinica.getDiagnostico());
    }

    @Override
    public void visitar(RecetaMedica recetaMedica) {
        System.out.println("Reporte receta: " + recetaMedica.getPaciente().getNombre()
                + " | Medicamento: " + recetaMedica.getMedicamento()
                + " | Dosis: " + recetaMedica.getDosis());
    }
}
