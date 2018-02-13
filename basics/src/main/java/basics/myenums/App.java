package basics.myenums;

public class App {

    public static void main( String[] args ) {
//        System.out.println(args[0]);
//        int mass = Integer.valueOf(args[0]);
        int mass = 80;
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
        Planet uranus = Planet.valueOf("URANUS");
        System.out.println(uranus);
    }

}

