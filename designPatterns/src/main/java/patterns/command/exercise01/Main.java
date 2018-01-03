package patterns.command.exercise01;

public class Main {
    public static void main(String[] args) {
        //TODO - function returning underlining OS system
        Reciver reciver = new WindowsFileSystemReciver();
        Command command = new OpenFileCommand(reciver);
        Invoker invoker = new Invoker(command);
        invoker.execute();


    }
}
