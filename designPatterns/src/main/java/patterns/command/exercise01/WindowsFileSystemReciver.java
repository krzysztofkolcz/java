package patterns.command.exercise01;

public class WindowsFileSystemReciver implements Reciver{

    public void openFile(){
        System.out.println("Windows Open File");
    }

    public void closeFile(){
        System.out.println("Windows Close File");
    }
}
