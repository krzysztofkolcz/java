package patterns.interpreter.exercises01;

public class BinaryInterpreter implements Expression{

    int i;

    public BinaryInterpreter(int i) {
        this.i = i;
    }

    @Override
    public String interpret(InterpreterContext ic){
        return ic.interpretBinary(this.i);
    }
}
