import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayDeque;
import java.util.Deque;


public class History {

    private final ObservableList<Memento> undoList = FXCollections.observableArrayList();
    private final Deque<Memento> redoStack = new ArrayDeque<>();


    public void save(Memento memento) {
        undoList.add(0, memento);
        redoStack.clear();
    }


    public Memento undo(Memento currentState) {
        if (undoList.isEmpty()) {
            return null;
        }

        redoStack.push(currentState);

        return undoList.remove(0);
    }


    public Memento redo(Memento currentState) {
        if (redoStack.isEmpty()) {
            return null;
        }

        undoList.add(0, currentState);

        return redoStack.pop();
    }


    public ObservableList<Memento> getUndoList() {
        return undoList;
    }
}