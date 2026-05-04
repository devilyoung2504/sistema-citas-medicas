package consultas;

import citas.CitaMedica;
import historias.HistoriaClinica;
import recetas.RecetaMedica;

public class ConsultaInterna extends ConsultaMedica {
    private static final RecetaMedica RECETA_CONTROL = new RecetaMedica(
            "Acetaminofen",
            "500 mg cada 8 horas",
            "Tomar por 3 dias si hay dolor o fiebre"
    );

    public ConsultaInterna(CitaMedica cita, HistoriaClinica historiaClinica) {
        super(cita, historiaClinica);
    }

    @Override
    protected void evaluarPaciente() {
        System.out.println("Evaluacion interna: signos vitales y sintomas generales.");
    }

    @Override
    protected void actualizarHistoriaClinica() {
        getHistoriaClinica().actualizar(
                "Cuadro viral leve",
                "Reposo, hidratacion y control de sintomas",
                "Paciente estable durante la consulta interna"
        );
    }

    @Override
    protected RecetaMedica generarReceta() {
        return RECETA_CONTROL.clonarPara(getCita().getPaciente());
    }
}
