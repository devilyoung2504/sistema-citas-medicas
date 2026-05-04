package consultas;

public enum TipoConsulta {
    INTERNA("Consulta interna"),
    EXTERNA("Consulta externa"),
    ESPECIALISTA("Consulta con especialista");

    private final String nombre;

    TipoConsulta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
