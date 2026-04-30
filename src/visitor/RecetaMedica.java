package visitor;

public class RecetaMedica implements ElementoMedico {
    private final String medicamento;
    private final String dosis;

    public RecetaMedica(String medicamento, String dosis) {
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    @Override
    public void aceptar(VisitanteMedico visitante) {
        visitante.visitar(this);
    }
}
