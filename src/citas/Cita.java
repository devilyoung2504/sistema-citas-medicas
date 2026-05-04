package citas;

import modelo.Paciente;
import reportes.ReporteVisitor;

public class Cita {
    private final String codigo;
    private final Paciente paciente;
    private final String tipo;
    private EstadoCita estado = EstadoCita.PROGRAMADA;

    public Cita(String codigo, Paciente paciente, String tipo) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.tipo = tipo;
    }

    public void avanzar() {
        estado = estado.siguiente();
    }

    public void cancelar() {
        estado = EstadoCita.CANCELADA;
    }

    public void mostrarEstado() {
        System.out.println("Cita " + codigo + " - Estado: " + estado);
    }

    public String getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado.toString();
    }

    public void aceptar(ReporteVisitor visitor) {
        visitor.visitar(this);
    }
}
