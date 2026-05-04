package citas;

import citas.estado.EstadoCita;
import citas.estado.EstadoProgramada;
import consultas.TipoConsulta;
import modelo.Paciente;
import reportes.ElementoReporte;
import reportes.VisitanteReporte;

public class CitaMedica implements ElementoReporte {
    private final String codigo;
    private final Paciente paciente;
    private final TipoConsulta tipoConsulta;
    private EstadoCita estado;

    public CitaMedica(String codigo, Paciente paciente, TipoConsulta tipoConsulta) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.tipoConsulta = tipoConsulta;
        this.estado = new EstadoProgramada();
    }

    public void cambiarEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public void avanzarEstado() {
        estado.avanzar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void mostrarEstado() {
        System.out.println("Cita " + codigo + " - " + paciente.getNombre()
                + " - " + tipoConsulta.getNombre()
                + " - Estado: " + estado.getNombre());
    }

    public String getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public String getNombreEstado() {
        return estado.getNombre();
    }

    @Override
    public void aceptar(VisitanteReporte visitante) {
        visitante.visitar(this);
    }
}
