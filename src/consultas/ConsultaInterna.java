package consultas;

import citas.Cita;
import historias.HistoriaClinica;

public class ConsultaInterna extends ConsultaMedica {
    public ConsultaInterna(Cita cita, HistoriaClinica historia) {
        super(cita, historia);
    }

    @Override
    protected void diagnosticar() {
        historia.actualizar("Chequeo interno estable", "Reposo e hidratacion");
    }

    @Override
    protected void recetar() {
        System.out.println("Receta general de consulta interna.");
    }
}
