package patterns.command.exercise01;

public class Invoker {
    public Command command;
    public Invoker(Command command){
        this.command = command;
    }

    public void execute(){
        this.command.execute();
    }
}
