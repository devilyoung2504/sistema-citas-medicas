package memento;

public class HistoriaMemento {
    private final String diagnostico;
    private final String tratamiento;

    public HistoriaMemento(String diagnostico, String tratamiento) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }
}
