package consultas;

import citas.Cita;
import historias.HistoriaClinica;

public class Consultas {
    public abstract static class ConsultaMedica {
        protected final Cita cita;
        protected final HistoriaClinica historia;

        public ConsultaMedica(Cita cita, HistoriaClinica historia) {
            this.cita = cita;
            this.historia = historia;
        }

        public final void atender() {
            registrar();
            diagnosticar();
            recetar();
            finalizar();
        }

        private void registrar() {
            System.out.println("Registrando paciente: " + cita.getPaciente().getNombre());
        }

        protected abstract void diagnosticar();

        protected abstract void recetar();

        private void finalizar() {
            cita.avanzar();
            cita.mostrarEstado();
        }
    }

    public static class Interna extends ConsultaMedica {
        public Interna(Cita cita, HistoriaClinica historia) {
            super(cita, historia);
        }

        @Override
        protected void diagnosticar() {
            historia.actualizar("Chequeo interno estable", "Reposo e hidratacion");
        }

        @Override
        protected void recetar() {
            System.out.println("Receta general de consulta interna.");
        }
    }

    public static class Externa extends ConsultaMedica {
        public Externa(Cita cita, HistoriaClinica historia) {
            super(cita, historia);
        }

        @Override
        protected void diagnosticar() {
            historia.actualizar("Dolor muscular leve", "Analgesico por dos dias");
        }

        @Override
        protected void recetar() {
            System.out.println("Receta ambulatoria de consulta externa.");
        }
    }

    public static class Especialista extends ConsultaMedica {
        public Especialista(Cita cita, HistoriaClinica historia) {
            super(cita, historia);
        }

        @Override
        protected void diagnosticar() {
            historia.actualizar("Hipertension en seguimiento", "Control con especialista");
        }

        @Override
        protected void recetar() {
            System.out.println("Receta segun criterio del especialista.");
        }
    }
}
