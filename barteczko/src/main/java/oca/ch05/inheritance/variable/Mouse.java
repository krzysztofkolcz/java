package oca.ch05.inheritance.variable;

class Rodent {

    private int processedFood = 4;
    protected int tailLength = 4;
    public int speed = 4;

    static private int speciesAvgStomachSize = 4;
    static protected int speciesAvgTailLength = 4;
    static public int speciesAvgSpeed = 4;

    public void getRodentDetails() {
			System.out.println("getRodentDetails()");
            System.out.println("[processedFood="+processedFood+"]");
            System.out.println("[parentTail="+tailLength+"]");
            System.out.println("[speed="+speed+"]");

			System.out.println("[speciesAvgStomachSize="+speciesAvgStomachSize+"]");
			System.out.println("[speciesAvgTailLength="+speciesAvgTailLength+"]");
			System.out.println("[speciesAvgSpeed="+speciesAvgSpeed+"]");
			System.out.println();
    }
}

public class Mouse extends Rodent {
    private int processedFood = 8;
    protected int tailLength = 8;
    public int speed = 8;

    static private int speciesAvgStomachSize = 8;
    static protected int speciesAvgTailLength = 8;
    static public int speciesAvgSpeed = 8;

    public void getMouseDetails() {
			System.out.println("getMouseDetails()");
            System.out.println("[processedFood="+processedFood+",parent= private NO ACCESS"+/*super.processedFood*/"]");
            System.out.println("[tail="+tailLength +",parent="+super.tailLength+"]");
            System.out.println("[speed="+speed +",parent="+super.speed+"]");
            System.out.println("[speciesAvgStomachSize="+speciesAvgStomachSize +",parent= private NO ACCESS"/*+super.speciesAvgStomachSize*/+"]");
            System.out.println("[speciesAvgTailLength="+speciesAvgTailLength +",parent="+super.speciesAvgTailLength+"]");
            System.out.println("[speciesAvgSpeed="+speciesAvgSpeed +",parent="+super.speciesAvgSpeed+"]");
            System.out.println();
    }
    public static void main(String[] args) {
            Mouse mouse = new Mouse();
            
			System.out.println("mouse.x");
			System.out.println(mouse.processedFood);//print: 8
			System.out.println(mouse.tailLength);//print: 8
			System.out.println(mouse.speed);//print: 8
			System.out.println(mouse.speciesAvgStomachSize);//print: 8
			System.out.println(mouse.speciesAvgTailLength);//print: 8
			System.out.println(mouse.speciesAvgSpeed);//print: 8
			System.out.println();

            
			Rodent rodent = new Rodent();
			System.out.println("rodent.x");
//			System.out.println(rodent.processedFood);//private
			System.out.println(rodent.tailLength);//print: 4
			System.out.println(rodent.speed);//print: 4
//			System.out.println(rodent.speciesAvgStomachSize);//private
			System.out.println(rodent.speciesAvgTailLength);//print: 4
			System.out.println(rodent.speciesAvgSpeed);//print: 4
			System.out.println();


			rodent = (Rodent)mouse;
			System.out.println("((Rodent)mouse).x");
//			System.out.println(rodent.processedFood);//private
			System.out.println(rodent.tailLength);//print: 4
			System.out.println(rodent.speed);//print: 4
//			System.out.println(rodent.speciesAvgStomachSize);//private
			System.out.println(rodent.speciesAvgTailLength);//print: 4
			System.out.println(rodent.speciesAvgSpeed);//print: 4
			System.out.println();

            mouse.getRodentDetails();//[parentTail=4]
            mouse.getMouseDetails();//[tail=8,parentTail=4]
            System.out.println(mouse.tailLength);//8
            System.out.println(((Rodent)mouse).tailLength);//4
    }
}
