package patterns.command.exercise01;

public class OpenFileCommand implements Command{

    Reciver reciver;

    public OpenFileCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void execute() {
        this.reciver.openFile();
    }
}
