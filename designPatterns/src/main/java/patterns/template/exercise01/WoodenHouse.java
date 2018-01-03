package patterns.template.exercise01;

public class WoodenHouse extends HouseTemplate{

    public void buildFoundation(){
        System.out.println("wooden house build foundation");
    }

    @Override
    public void buildPillars() {
        System.out.println("wooden house build pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("wooden house build walls");
    }
}
