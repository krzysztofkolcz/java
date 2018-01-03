package patterns.memento.exercises03;

public class Originator {
    private String fileName;
    private StringBuilder content;

    public Originator(String fileName) {
        this.fileName = fileName;
        content = new StringBuilder();
    }

    @Override
    public String toString() {
        return "Originator{" +
                "fileName='" + fileName + '\'' +
                ", content=" + content +
                '}';
    }

    public void write(String str){
        content.append(str);
    }

    public Memento save(){
        return new Memento(fileName,content.toString());
    }

    public void undo(Object obj){
        Memento memento = (Memento)obj;
        this.fileName = memento.fileName;
        this.content = memento.content;
    }

    private class Memento{
        private String fileName;
        private StringBuilder content;

        public Memento(String fileName, String content) {
            this.fileName = fileName;
            this.content = new StringBuilder(content);
        }
    }
}
