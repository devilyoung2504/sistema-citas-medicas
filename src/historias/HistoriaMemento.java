package historias;

public class HistoriaMemento {
    private final String diagnostico;
    private final String tratamiento;
    private final String observaciones;

    public HistoriaMemento(String diagnostico, String tratamiento, String observaciones) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
