package consultas;

import citas.CitaMedica;
import historias.HistoriaClinica;
import recetas.RecetaMedica;

public class ConsultaEspecialista extends ConsultaMedica {
    private static final RecetaMedica RECETA_ESPECIALISTA = new RecetaMedica(
            "Losartan",
            "50 mg cada 24 horas",
            "Tomar en la manana y asistir a control"
    );

    private final String especialidad;

    public ConsultaEspecialista(CitaMedica cita, HistoriaClinica historiaClinica, String especialidad) {
        super(cita, historiaClinica);
        this.especialidad = especialidad;
    }

    @Override
    protected void evaluarPaciente() {
        System.out.println("Evaluacion de especialista en " + especialidad + ".");
    }

    @Override
    protected void actualizarHistoriaClinica() {
        getHistoriaClinica().actualizar(
                "Hipertension en seguimiento por " + especialidad,
                "Continuar medicamento y registrar presion arterial",
                "Se programa control especializado en 30 dias"
        );
    }

    @Override
    protected RecetaMedica generarReceta() {
        RecetaMedica receta = RECETA_ESPECIALISTA.clonarPara(getCita().getPaciente());
        receta.ajustarDosis("50 mg cada 24 horas por 30 dias");
        return receta;
    }
}
