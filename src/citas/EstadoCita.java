package citas;

public enum EstadoCita {
    PROGRAMADA("Programada"),
    FINALIZADA("Finalizada"),
    CANCELADA("Cancelada");

    private final String nombre;

    EstadoCita(String nombre) {
        this.nombre = nombre;
    }

    public EstadoCita siguiente() {
        if (this == PROGRAMADA) {
            return FINALIZADA;
        }
        return this;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
