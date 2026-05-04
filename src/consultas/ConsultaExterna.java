package consultas;

import citas.CitaMedica;
import historias.HistoriaClinica;
import recetas.RecetaMedica;

public class ConsultaExterna extends ConsultaMedica {
    private static final RecetaMedica RECETA_AMBULATORIA = new RecetaMedica(
            "Ibuprofeno",
            "400 mg cada 12 horas",
            "Tomar despues de las comidas por 2 dias"
    );

    public ConsultaExterna(CitaMedica cita, HistoriaClinica historiaClinica) {
        super(cita, historiaClinica);
    }

    @Override
    protected void evaluarPaciente() {
        System.out.println("Evaluacion externa: revision ambulatoria y motivo de consulta.");
    }

    @Override
    protected void actualizarHistoriaClinica() {
        getHistoriaClinica().actualizar(
                "Dolor muscular leve",
                "Manejo ambulatorio con analgesico",
                "Se recomienda volver si los sintomas aumentan"
        );
    }

    @Override
    protected RecetaMedica generarReceta() {
        RecetaMedica receta = RECETA_AMBULATORIA.clonarPara(getCita().getPaciente());
        receta.ajustarIndicaciones("Tomar solo si presenta dolor. No exceder la dosis indicada");
        return receta;
    }
}
