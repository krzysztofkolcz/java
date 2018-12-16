package oca.tests;

class MySpecialException extends RuntimeException{

	public MySpecialException(String string) {
		super(string);
	}

}

class MySpecialException2 extends Exception{
	
}


public class UncheckedException {
    public static void main(String[] args) throws MySpecialException2{
        try {
            doSomething();
        } catch (MySpecialException e) {
            System.out.println(e);
        }
    }

    static void doSomething() {
        int[] array = new int[4];
        array[4] = 4;
        doSomethingElse();
    }

    static void doSomethingElse() {
        throw new MySpecialException("Sorry, can't do something else");
    }
}
