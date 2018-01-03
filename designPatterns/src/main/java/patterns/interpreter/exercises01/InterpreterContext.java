package patterns.interpreter.exercises01;

public class InterpreterContext {

    public String interpretBinary(int i){
        return Integer.toBinaryString(i);
    }

    public String interpretHex(int i){
        return Integer.toHexString(i);
    }
}
