package historias;

import modelo.Paciente;
import reportes.ReporteVisitor;

public class HistoriaClinica {
    private final Paciente paciente;
    private String diagnostico = "Sin diagnostico";
    private String tratamiento = "Sin tratamiento";

    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
    }

    public void actualizar(String diagnostico, String tratamiento) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public HistoriaMemento guardar() {
        return new HistoriaMemento(diagnostico, tratamiento);
    }

    public void restaurar(HistoriaMemento memento) {
        diagnostico = memento.getDiagnostico();
        tratamiento = memento.getTratamiento();
    }

    public void mostrar() {
        System.out.println("Historia de " + paciente.getNombre());
        System.out.println("Diagnostico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void aceptar(ReporteVisitor visitor) {
        visitor.visitar(this);
    }
}
