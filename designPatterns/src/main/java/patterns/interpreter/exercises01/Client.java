package patterns.interpreter.exercises01;

public class Client {
    InterpreterContext ic;

    public Client() {
        this.ic = new InterpreterContext();
    }

    public void test(){
//        String input = "30 Hexadecimal";
        HexInterpreter hexInterpreter = new HexInterpreter(30);
        System.out.println(hexInterpreter.interpret(this.ic));
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.test();
    }
}
