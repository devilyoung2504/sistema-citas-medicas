import citas.Cita;
import consultas.ConsultaEspecialista;
import consultas.ConsultaExterna;
import consultas.ConsultaInterna;
import consultas.ConsultaMedica;
import historias.HistoriaClinica;
import historias.HistorialCambios;
import modelo.Paciente;
import recetas.Receta;
import reportes.ReporteVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA BASICO DE CITAS MEDICAS");

        atenderConsultaInterna();
        atenderConsultaExterna();
        atenderConsultaEspecialista();
        cancelarCita();
    }

    private static void atenderConsultaInterna() {
        System.out.println();
        System.out.println("=== Consulta interna ===");
        Paciente paciente = new Paciente("Ana Torres");
        Cita cita = new Cita("C-001", paciente, "Interna");
        HistoriaClinica historia = new HistoriaClinica(paciente);

        ConsultaMedica consulta = new ConsultaInterna(cita, historia);
        consulta.atender();

        historia.mostrar();
    }

    private static void atenderConsultaExterna() {
        System.out.println();
        System.out.println("=== Consulta externa ===");
        Paciente paciente = new Paciente("Luis Perez");
        Cita cita = new Cita("C-002", paciente, "Externa");
        HistoriaClinica historia = new HistoriaClinica(paciente);

        ConsultaMedica consulta = new ConsultaExterna(cita, historia);
        consulta.atender();

        historia.mostrar();
    }

    private static void atenderConsultaEspecialista() {
        System.out.println();
        System.out.println("=== Consulta especialista ===");
        Paciente paciente = new Paciente("Marta Rojas");
        Cita cita = new Cita("C-003", paciente, "Especialista");
        Receta recetaBase = new Receta("Acetaminofen", "500 mg cada 8 horas");
        HistoriaClinica historia = new HistoriaClinica(paciente);
        HistorialCambios historial = new HistorialCambios();

        ConsultaMedica consulta = new ConsultaEspecialista(cita, historia);
        consulta.atender();

        historial.guardar(historia.guardar());
        Receta recetaPaciente = recetaBase.clonarPara(paciente);

        historia.mostrar();
        recetaPaciente.mostrar();

        System.out.println();
        System.out.println("Se corrige un error en la historia:");
        historia.actualizar("Diagnostico equivocado", "Tratamiento equivocado");
        historia.mostrar();

        System.out.println("Se restaura la version anterior:");
        historia.restaurar(historial.deshacer());
        historia.mostrar();

        System.out.println();
        System.out.println("Reporte final:");
        ReporteVisitor reporte = new ReporteVisitor();
        cita.aceptar(reporte);
        historia.aceptar(reporte);
        recetaPaciente.aceptar(reporte);
    }

    private static void cancelarCita() {
        System.out.println();
        System.out.println("=== Cancelacion de cita ===");
        Paciente paciente = new Paciente("Carlos Diaz");
        Cita cita = new Cita("C-004", paciente, "Externa");

        cita.mostrarEstado();
        cita.cancelar();
        cita.mostrarEstado();
    }
}
