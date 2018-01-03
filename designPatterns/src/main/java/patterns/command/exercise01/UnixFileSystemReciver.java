package patterns.command.exercise01;

public class UnixFileSystemReciver implements Reciver{

    public void openFile(){
        System.out.println("Unix Open File");
    }

    public void closeFile(){
        System.out.println("Unix Close File");
    }
}
