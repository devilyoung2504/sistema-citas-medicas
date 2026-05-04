package reportes;

import citas.CitaMedica;
import historias.HistoriaClinica;
import recetas.RecetaMedica;

public interface VisitanteReporte {
    void visitar(CitaMedica cita);

    void visitar(HistoriaClinica historiaClinica);

    void visitar(RecetaMedica recetaMedica);
}
