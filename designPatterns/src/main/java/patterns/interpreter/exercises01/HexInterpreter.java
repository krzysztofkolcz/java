package patterns.interpreter.exercises01;

public class HexInterpreter implements Expression{

    int i;

    public HexInterpreter(int i) {
        this.i = i;
    }

    @Override
    public String interpret(InterpreterContext ic){
        return ic.interpretHex(this.i);
    }
}
