package consultas;

import citas.Cita;
import historias.HistoriaClinica;

public class ConsultaEspecialista extends ConsultaMedica {
    public ConsultaEspecialista(Cita cita, HistoriaClinica historia) {
        super(cita, historia);
    }

    @Override
    protected void diagnosticar() {
        historia.actualizar("Hipertension en seguimiento", "Control con especialista");
    }

    @Override
    protected void recetar() {
        System.out.println("Receta segun criterio del especialista.");
    }
}
