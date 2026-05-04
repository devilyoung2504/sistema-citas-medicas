package consultas;

import citas.Cita;
import historias.HistoriaClinica;

public class ConsultaExterna extends ConsultaMedica {
    public ConsultaExterna(Cita cita, HistoriaClinica historia) {
        super(cita, historia);
    }

    @Override
    protected void diagnosticar() {
        historia.actualizar("Dolor muscular leve", "Analgesico por dos dias");
    }

    @Override
    protected void recetar() {
        System.out.println("Receta ambulatoria de consulta externa.");
    }
}
