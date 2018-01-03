package patterns.command.exercise01;

public class CloseFileCommand implements Command {

    Reciver reciver;

    public CloseFileCommand(Reciver reciver) {
        this.reciver = reciver;
    }
    @Override
    public void execute() {
        this.reciver.closeFile();

    }
}
