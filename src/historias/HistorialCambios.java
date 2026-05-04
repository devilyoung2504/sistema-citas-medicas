package historias;

import java.util.Stack;

public class HistorialCambios {
    private final Stack<HistoriaMemento> versiones = new Stack<>();

    public void guardar(HistoriaMemento version) {
        versiones.push(version);
    }

    public HistoriaMemento obtenerUltimaVersion() {
        if (versiones.isEmpty()) {
            return null;
        }
        return versiones.pop();
    }
}
