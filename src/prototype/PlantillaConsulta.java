package prototype;

public class PlantillaConsulta {
    private String tipo;
    private int duracionMinutos;
    private String descripcion;

    public PlantillaConsulta(String tipo, int duracionMinutos, String descripcion) {
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
        this.descripcion = descripcion;
    }

    public PlantillaConsulta clonar() {
        return new PlantillaConsulta(tipo, duracionMinutos, descripcion);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void mostrar() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Duracion: " + duracionMinutos + " minutos");
        System.out.println("Descripcion: " + descripcion);
    }
}
