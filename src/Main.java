import citas.Cita;
import consultas.Consultas;
import historias.HistoriaClinica;
import modelo.Paciente;
import recetas.Receta;
import reportes.ReporteVisitor;

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("Ana Torres");
        Cita cita = new Cita("C-001", paciente, "Especialista");
        HistoriaClinica historia = new HistoriaClinica(paciente);

        System.out.println("SISTEMA BASICO DE CITAS MEDICAS");

        Consultas.ConsultaMedica consulta = new Consultas.Especialista(cita, historia);
        consulta.atender();

        historia.guardar();
        Receta receta = new Receta("Acetaminofen", "500 mg cada 8 horas").clonarPara(paciente);

        System.out.println();
        historia.mostrar();
        receta.mostrar();

        System.out.println();
        System.out.println("Se corrige un error en la historia:");
        historia.actualizar("Diagnostico equivocado", "Tratamiento equivocado");
        historia.mostrar();

        System.out.println("Se restaura la version anterior:");
        historia.deshacer();
        historia.mostrar();

        System.out.println();
        System.out.println("Reporte final:");
        ReporteVisitor reporte = new ReporteVisitor();
        cita.aceptar(reporte);
        historia.aceptar(reporte);
        receta.aceptar(reporte);
    }
}
