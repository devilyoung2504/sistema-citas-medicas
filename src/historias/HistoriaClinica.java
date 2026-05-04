package historias;

import java.util.Stack;

import modelo.Paciente;
import reportes.ReporteVisitor;

public class HistoriaClinica {
    private final Paciente paciente;
    private String diagnostico = "Sin diagnostico";
    private String tratamiento = "Sin tratamiento";
    private final Stack<Memento> historial = new Stack<>();

    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
    }

    public void actualizar(String diagnostico, String tratamiento) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public void guardar() {
        historial.push(new Memento(diagnostico, tratamiento));
    }

    public void deshacer() {
        Memento memento = historial.pop();
        diagnostico = memento.diagnostico;
        tratamiento = memento.tratamiento;
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

    private static class Memento {
        private final String diagnostico;
        private final String tratamiento;

        public Memento(String diagnostico, String tratamiento) {
            this.diagnostico = diagnostico;
            this.tratamiento = tratamiento;
        }
    }
}
