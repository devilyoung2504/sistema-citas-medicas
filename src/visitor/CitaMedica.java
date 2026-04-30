package visitor;

public class CitaMedica implements ElementoMedico {
    private final String codigo;
    private final String paciente;
    private final String tipoConsulta;

    public CitaMedica(String codigo, String paciente, String tipoConsulta) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.tipoConsulta = tipoConsulta;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    @Override
    public void aceptar(VisitanteMedico visitante) {
        visitante.visitar(this);
    }
}
