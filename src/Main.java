import memento.HistoriaClinica;
import memento.HistorialCambios;
import prototype.PlantillaConsulta;
import state.Cita;
import template.ConsultaEspecialista;
import template.ConsultaExterna;
import template.ConsultaInterna;
import visitor.CitaMedica;
import visitor.ElementoMedico;
import visitor.HistoriaClinicaResumen;
import visitor.RecetaMedica;
import visitor.ReporteMedicoVisitor;

public class Main {
    public static void main(String[] args) {
        demostrarTemplateMethod();
        demostrarMemento();
        demostrarVisitor();
        demostrarPrototype();
        demostrarState();
    }

    private static void demostrarTemplateMethod() {
        System.out.println("=== TEMPLATE METHOD ===");
        new ConsultaInterna("Ana Torres", "C-101").atenderConsulta();
        System.out.println();
        new ConsultaExterna("Luis Perez", "C-102").atenderConsulta();
        System.out.println();
        new ConsultaEspecialista("Marta Rojas", "C-103", "Cardiologia").atenderConsulta();
        System.out.println();
    }

    private static void demostrarMemento() {
        System.out.println("=== MEMENTO ===");
        HistoriaClinica historia = new HistoriaClinica(
                "Ana Torres",
                "Migrana moderada",
                "Reposo e hidratacion"
        );
        HistorialCambios historial = new HistorialCambios();

        historia.mostrar();
        historial.guardar(historia.guardar());

        historia.setDiagnostico("Migrana con sospecha de sinusitis");
        historia.setTratamiento("Analgesico, hidratacion y control en 48 horas");
        System.out.println("Historia actualizada:");
        historia.mostrar();

        historia.restaurar(historial.deshacer());
        System.out.println("Historia restaurada:");
        historia.mostrar();
        System.out.println();
    }

    private static void demostrarVisitor() {
        System.out.println("=== VISITOR ===");
        ReporteMedicoVisitor reporte = new ReporteMedicoVisitor();

        ElementoMedico[] elementos = {
                new CitaMedica("C-103", "Marta Rojas", "Especialista"),
                new HistoriaClinicaResumen("Marta Rojas", "Control cardiologico estable"),
                new RecetaMedica("Atorvastatina", "1 tableta nocturna")
        };

        for (ElementoMedico elemento : elementos) {
            elemento.aceptar(reporte);
        }
        System.out.println();
    }

    private static void demostrarPrototype() {
        System.out.println("=== PROTOTYPE ===");
        PlantillaConsulta plantillaBase = new PlantillaConsulta(
                "Consulta interna",
                30,
                "Valoracion general de medicina interna"
        );
        PlantillaConsulta plantillaClonada = plantillaBase.clonar();
        plantillaClonada.setTipo("Consulta especialista");
        plantillaClonada.setDuracionMinutos(45);
        plantillaClonada.setDescripcion("Valoracion especializada en cardiologia");

        System.out.println("Plantilla base:");
        plantillaBase.mostrar();
        System.out.println("Plantilla clonada:");
        plantillaClonada.mostrar();
        System.out.println();
    }

    private static void demostrarState() {
        System.out.println("=== STATE ===");
        Cita cita = new Cita("C-200", "Pedro Gomez");
        cita.mostrarEstado();
        cita.siguienteEstado();
        cita.mostrarEstado();
        cita.siguienteEstado();
        cita.mostrarEstado();
        cita.siguienteEstado();
        cita.mostrarEstado();

        Cita citaCancelada = new Cita("C-201", "Laura Diaz");
        citaCancelada.mostrarEstado();
        citaCancelada.cancelar();
        citaCancelada.mostrarEstado();
        citaCancelada.siguienteEstado();
        System.out.println();
    }
}
