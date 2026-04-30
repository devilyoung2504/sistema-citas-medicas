package state;

public class Cita {
    private final String codigo;
    private final String paciente;
    private EstadoCita estado;

    public Cita(String codigo, String paciente) {
        this.codigo = codigo;
        this.paciente = paciente;
        estado = new EstadoProgramada();
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public void siguienteEstado() {
        estado.siguiente(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void mostrarEstado() {
        System.out.println("Cita " + codigo + " de " + paciente + " -> estado actual: " + estado.getNombre());
    }
}
