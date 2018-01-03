package patterns.memento.exercises03;

public class Caretaker {
    Object memento;

    public void save(Originator org){
        this.memento = org.save();
    }

    public void undo(Originator org){
        org.undo(memento);
    }
}
