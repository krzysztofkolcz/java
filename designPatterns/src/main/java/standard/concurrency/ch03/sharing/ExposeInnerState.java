package standard.concurrency.ch03.sharing;

import java.util.Arrays;

public class ExposeInnerState {
    private String[] innerStates = {"AA","BB","CC"};
    public String[] getStates(){
        return innerStates;
    }
    public void printStates(){
        Arrays.stream(innerStates).forEach(System.out::println);
    }

    public static void main(String[] args) {
        ExposeInnerState exposeInnerState = new ExposeInnerState();
        exposeInnerState.printStates();
        System.out.println();
        String[] innerStates = exposeInnerState.getStates();
        innerStates[0] = "XX";
        exposeInnerState.printStates();
    }
}
