package standard.enums;

import java.util.Arrays;

public enum Planets {
    MERCURY(60,50),
    VENUS(98,80),
    EARTH(100,100);

    private int mass;
    private int radius;

    private Planets(int mass,int radius){
        this.mass = mass;
        this.radius = radius;
    }

    public String getMassString(){
        return String.valueOf(mass);
    }


    public static void main(String[] args) {
        Arrays.stream(Planets.values()).forEach( n -> System.out.println( n + n.getMassString()));
    }
}
