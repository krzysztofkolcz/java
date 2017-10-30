package ch03;

/**
 * Created by kkolcz on 30/10/17.
 */
public class Finally01 {

    public static void main(String[] args) {
        try {
            Finally01 finally01 = new Finally01();
            int result = finally01.testingMethod();
            System.out.println(result);

            finally01.testingMethod02();
            System.out.println("statement after testingMethod02");
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public int testingMethod() throws InterruptedException {
        try{
            return 120;
        }finally{
            Thread.sleep(1000);
            System.out.println("Finally block");
        }
    }

    public int testingMethod02() throws Exception {
        try{
            throw new Exception("Some Exception");
        }finally{
            Thread.sleep(1000);
            System.out.println("Finally block");
        }
    }
}
