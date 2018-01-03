package standard.exceptions;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.method();
        System.out.println("Result:"+result);
    }

    public int method(){
        System.out.println("Method");
        try {
            throw new Exception();
        }catch(InterruptedException e){
            System.out.println("InterruptedException catched");
            return 1;
        }catch(Exception e){
            System.out.println("Exception catched");
            return 2;
        }finally {
            System.out.println("Finally");
        }
    }

}
