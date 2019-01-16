package ch03.exceptions;

public class Oca002 {

    public static void main(String[] args) {
        Oca002 oca002 = new Oca002();
        oca002.explore();

    }

    void explore() {
        try {
            fall();
            System.out.println("never get here");
        } catch (RuntimeException e) {
            getUp();
        }
        seeAnimals();
    }

    void fall() {
        throw new RuntimeException();
    }

    void getUp(){
        System.out.println("getUp");
    }

    void seeAnimals(){
        System.out.println("seeAnimals");
    }

}
