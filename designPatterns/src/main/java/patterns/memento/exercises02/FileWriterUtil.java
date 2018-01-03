package patterns.memento.exercises02;

public class FileWriterUtil {

    private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String fileName, StringBuilder content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void write(String string){
        this.content.append(string);
    }

    public String toString(){
        return fileName + ":" + content.toString();
    }

    public Memento save(){
        return new Memento(fileName,content);
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
}
