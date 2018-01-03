package patterns.memento.exercises02;

public class FileWriterClient {
    public static void main(String[] args) {
        FileWriterUtil fileWriterUtil = new FileWriterUtil("fileName.txt",new StringBuilder("initial content"));
        FileWriterCaretaker fileWriterCaretaker = new FileWriterCaretaker();
        fileWriterCaretaker.save(fileWriterUtil);
    }
}
