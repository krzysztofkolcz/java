package patterns.memento.exercises01;

public class FileWriterClient {

    public void save(){

    }

    public void undo(){

    }

    public static void main(String[] args) {
        FileWriterUtil fileWriterUtil = new FileWriterUtil("test.txt",new StringBuilder("content"));
        fileWriterUtil.write("\n next Line");
        FileWriterCaretaker fileWriterCaretaker = new FileWriterCaretaker();
        fileWriterCaretaker.save(fileWriterUtil);
        System.out.println(fileWriterUtil);
        System.out.println("\n");

        fileWriterUtil.write("\n second Line");
        System.out.println(fileWriterUtil);
        System.out.println("\n");

        fileWriterCaretaker.undo(fileWriterUtil);
        System.out.println(fileWriterUtil);
        System.out.println("\n");

    }
}
