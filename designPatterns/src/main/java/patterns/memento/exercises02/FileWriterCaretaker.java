package patterns.memento.exercises02;

import java.util.ArrayDeque;

public class FileWriterCaretaker {

    private ArrayDeque<Object> queue = new ArrayDeque<>();

    public void save(FileWriterUtil util){
        Object obj = util.save();
        queue.addFirst(obj);
    }

    public void undo(FileWriterUtil util){
        Object obj = queue.poll();
        util.undo(obj);
    }
}
