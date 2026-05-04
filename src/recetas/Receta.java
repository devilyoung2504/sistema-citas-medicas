package recetas;

import modelo.Paciente;
import reportes.ReporteVisitor;

public class Receta {
    private Paciente paciente;
    private final String medicamento;
    private final String dosis;

    public Receta(String medicamento, String dosis) {
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    public Receta clonarPara(Paciente paciente) {
        Receta copia = new Receta(medicamento, dosis);
        copia.paciente = paciente;
        return copia;
    }

    public void mostrar() {
        System.out.println("Receta para " + paciente.getNombre() + ": " + medicamento + ", " + dosis);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void aceptar(ReporteVisitor visitor) {
        visitor.visitar(this);
    }
}
