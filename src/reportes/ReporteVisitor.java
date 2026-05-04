package reportes;

import citas.Cita;
import historias.HistoriaClinica;
import recetas.Receta;

public class ReporteVisitor {
    public void visitar(Cita cita) {
        System.out.println("Cita: " + cita.getCodigo()
                + " | Paciente: " + cita.getPaciente().getNombre()
                + " | Estado: " + cita.getEstado());
    }

    public void visitar(HistoriaClinica historia) {
        System.out.println("Historia: " + historia.getPaciente().getNombre()
                + " | Diagnostico: " + historia.getDiagnostico());
    }

    public void visitar(Receta receta) {
        System.out.println("Receta: " + receta.getMedicamento()
                + " | Dosis: " + receta.getDosis());
    }
}
