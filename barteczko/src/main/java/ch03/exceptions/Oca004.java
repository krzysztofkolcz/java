package ch03.exceptions;

public class Oca004 {
    public void bad() {
        try {
            eatCarrot();
        }catch(Exception e) {//OK
//        } catch (NoMoreCarrotsException e ) {// DOES NOT COMPILE
            System.out.print("sad rabbit");
        }
    }
    public void good() throws NoMoreCarrotsException {
        eatCarrot();
    }
    private static void eatCarrot() { }
}
