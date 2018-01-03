package patterns.memento.exercises01;

public class FileWriterUtil {

    private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String fileName, StringBuilder content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void write(String newContent){
        content.append(newContent);
    }

    public Memento save(){
        return new Memento(fileName, this.content);
    }

    public void undo(Object obj){
        Memento memento = (Memento)obj;
        this.fileName = memento.fileName;
        this.content = memento.content;
    }

    private class Memento{
        private String fileName;
        private StringBuilder content;

        public Memento(String fileName, StringBuilder content) {
            this.fileName = fileName;
            this.content = new StringBuilder(content);
        }
    }

    public String toString(){
        return fileName + ":" + content.toString();
    }
}
