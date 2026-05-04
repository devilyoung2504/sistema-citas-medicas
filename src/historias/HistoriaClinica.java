package historias;

import modelo.Paciente;
import reportes.ElementoReporte;
import reportes.VisitanteReporte;

public class HistoriaClinica implements ElementoReporte {
    private final Paciente paciente;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;

    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
        this.diagnostico = "Sin diagnostico registrado";
        this.tratamiento = "Sin tratamiento registrado";
        this.observaciones = "Sin observaciones";
    }

    public void actualizar(String diagnostico, String tratamiento, String observaciones) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public HistoriaMemento guardarVersion() {
        return new HistoriaMemento(diagnostico, tratamiento, observaciones);
    }

    public void restaurar(HistoriaMemento version) {
        if (version == null) {
            System.out.println("No hay una version anterior de la historia clinica.");
            return;
        }

        diagnostico = version.getDiagnostico();
        tratamiento = version.getTratamiento();
        observaciones = version.getObservaciones();
    }

    public void mostrar() {
        System.out.println("Historia clinica de " + paciente.getNombre());
        System.out.println("Diagnostico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
        System.out.println("Observaciones: " + observaciones);
    }

    public Paciente getPaciente() {
        return paciente;
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

    @Override
    public void aceptar(VisitanteReporte visitante) {
        visitante.visitar(this);
    }
}
