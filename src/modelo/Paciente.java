package modelo;

public class Paciente {
    private final String documento;
    private final String nombre;
    private final int edad;

    public Paciente(String documento, String nombre, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
