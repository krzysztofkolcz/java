package patterns.memento.exercises01;

public class FileWriterCaretaker {

    Object obj;

    public void save(FileWriterUtil fileWriterUtil){
        this.obj = fileWriterUtil.save();
    }

    public void undo(FileWriterUtil fileWriterUtil){
        fileWriterUtil.undo(this.obj);
    }
}
