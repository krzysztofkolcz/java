package oca.ch05.inheritance.variable;

public class Rodent {

    private int processedFood = 4;
    protected int tailLength = 4;
    public int speed = 4;

    static private int speciesAvgStomachSize = 4;
    static protected int speciesAvgTailLength = 4;
    static public int speciesAvgSpeed = 4;

    public void getRodentDetails() {
            System.out.println("[processedFood="+processedFood+"]");
            System.out.println("[parentTail="+tailLength+"]");
            System.out.println("[speed="+speed+"]");

			System.out.println("[speciesAvgStomachSize="+speciesAvgStomachSize+"]");
			System.out.println("[speciesAvgTailLength="+speciesAvgTailLength+"]");
			System.out.println("[speciesAvgSpeed="+speciesAvgSpeed+"]");
    }
}