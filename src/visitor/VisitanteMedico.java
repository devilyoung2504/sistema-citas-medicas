package visitor;

public interface VisitanteMedico {
    void visitar(CitaMedica cita);

    void visitar(HistoriaClinicaResumen historiaClinica);

    void visitar(RecetaMedica receta);
}
