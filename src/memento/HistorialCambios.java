package memento;

import java.util.Stack;

public class HistorialCambios {
    private final Stack<HistoriaMemento> historial = new Stack<>();

    public void guardar(HistoriaMemento memento) {
        historial.push(memento);
    }

    public HistoriaMemento deshacer() {
        if (historial.isEmpty()) {
            return null;
        }
        return historial.pop();
    }
}
