import citas.CitaMedica;
import consultas.ConsultaEspecialista;
import consultas.ConsultaExterna;
import consultas.ConsultaInterna;
import consultas.ConsultaMedica;
import consultas.TipoConsulta;
import historias.HistoriaClinica;
import historias.HistorialCambios;
import modelo.Paciente;
import recetas.RecetaMedica;
import reportes.ElementoReporte;
import reportes.ReporteMedicoVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA BASICO DE ATENCION DE CITAS MEDICAS");
        System.out.println();

        atenderConsultaInterna();
        atenderConsultaExterna();
        atenderConsultaEspecialista();
        demostrarCancelacionDeCita();
    }

    private static void atenderConsultaInterna() {
        Paciente paciente = new Paciente("1001", "Ana Torres", 32);
        CitaMedica cita = new CitaMedica("C-001", paciente, TipoConsulta.INTERNA);
        HistoriaClinica historia = new HistoriaClinica(paciente);
        HistorialCambios historial = new HistorialCambios();

        System.out.println("=== Consulta interna ===");
        cita.mostrarEstado();
        historial.guardar(historia.guardarVersion());

        ConsultaMedica consulta = new ConsultaInterna(cita, historia);
        consulta.atender();

        historial.guardar(historia.guardarVersion());
        System.out.println();
        historia.mostrar();
        System.out.println();
        consulta.getRecetaGenerada().mostrar();

        System.out.println();
        System.out.println("Correccion academica con Memento:");
        historia.actualizar(
                "Diagnostico escrito por error",
                "Tratamiento escrito por error",
                "Se debe restaurar la version anterior"
        );
        historia.mostrar();
        historia.restaurar(historial.obtenerUltimaVersion());
        System.out.println("Historia restaurada:");
        historia.mostrar();

        generarReporte(cita, historia, consulta.getRecetaGenerada());
        System.out.println();
    }

    private static void atenderConsultaExterna() {
        Paciente paciente = new Paciente("1002", "Luis Perez", 45);
        CitaMedica cita = new CitaMedica("C-002", paciente, TipoConsulta.EXTERNA);
        HistoriaClinica historia = new HistoriaClinica(paciente);

        System.out.println("=== Consulta externa ===");
        ConsultaMedica consulta = new ConsultaExterna(cita, historia);
        consulta.atender();
        generarReporte(cita, historia, consulta.getRecetaGenerada());
        System.out.println();
    }

    private static void atenderConsultaEspecialista() {
        Paciente paciente = new Paciente("1003", "Marta Rojas", 58);
        CitaMedica cita = new CitaMedica("C-003", paciente, TipoConsulta.ESPECIALISTA);
        HistoriaClinica historia = new HistoriaClinica(paciente);

        System.out.println("=== Consulta especialista ===");
        ConsultaMedica consulta = new ConsultaEspecialista(cita, historia, "Cardiologia");
        consulta.atender();
        generarReporte(cita, historia, consulta.getRecetaGenerada());
        System.out.println();
    }

    private static void demostrarCancelacionDeCita() {
        Paciente paciente = new Paciente("1004", "Carlos Diaz", 28);
        CitaMedica cita = new CitaMedica("C-004", paciente, TipoConsulta.EXTERNA);

        System.out.println("=== Cancelacion de cita ===");
        cita.mostrarEstado();
        cita.cancelar();
        cita.mostrarEstado();
        cita.avanzarEstado();
    }

    private static void generarReporte(CitaMedica cita, HistoriaClinica historia, RecetaMedica receta) {
        ReporteMedicoVisitor reporte = new ReporteMedicoVisitor();
        ElementoReporte[] elementos = {cita, historia, receta};

        System.out.println();
        System.out.println("Reporte general:");
        for (ElementoReporte elemento : elementos) {
            elemento.aceptar(reporte);
        }
    }
}
