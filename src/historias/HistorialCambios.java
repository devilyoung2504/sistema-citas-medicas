package historias;

import java.util.Stack;

public class HistorialCambios {
    private final Stack<HistoriaMemento> historial = new Stack<>();

    public void guardar(HistoriaMemento memento) {
        historial.push(memento);
    }

    public HistoriaMemento deshacer() {
        return historial.pop();
    }
}
