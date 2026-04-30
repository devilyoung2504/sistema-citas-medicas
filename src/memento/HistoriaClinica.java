package memento;

public class HistoriaClinica {
    private final String paciente;
    private String diagnostico;
    private String tratamiento;

    public HistoriaClinica(String paciente, String diagnostico, String tratamiento) {
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public HistoriaMemento guardar() {
        return new HistoriaMemento(diagnostico, tratamiento);
    }

    public void restaurar(HistoriaMemento memento) {
        if (memento == null) {
            System.out.println("No hay una version previa para restaurar.");
            return;
        }
        diagnostico = memento.getDiagnostico();
        tratamiento = memento.getTratamiento();
    }

    public void mostrar() {
        System.out.println("Paciente: " + paciente);
        System.out.println("Diagnostico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
    }
}
