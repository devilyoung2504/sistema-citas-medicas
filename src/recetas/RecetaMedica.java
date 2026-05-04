package recetas;

import modelo.Paciente;
import reportes.ElementoReporte;
import reportes.VisitanteReporte;

public class RecetaMedica implements ElementoReporte {
    private Paciente paciente;
    private final String medicamento;
    private String dosis;
    private String indicaciones;

    public RecetaMedica(String medicamento, String dosis, String indicaciones) {
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.indicaciones = indicaciones;
    }

    public RecetaMedica clonarPara(Paciente paciente) {
        RecetaMedica copia = new RecetaMedica(medicamento, dosis, indicaciones);
        copia.paciente = paciente;
        return copia;
    }

    public void ajustarDosis(String dosis) {
        this.dosis = dosis;
    }

    public void ajustarIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public void mostrar() {
        System.out.println("Receta para " + paciente.getNombre());
        System.out.println("Medicamento: " + medicamento);
        System.out.println("Dosis: " + dosis);
        System.out.println("Indicaciones: " + indicaciones);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    @Override
    public void aceptar(VisitanteReporte visitante) {
        visitante.visitar(this);
    }
}
