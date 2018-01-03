package patterns.template.exercise01;

public abstract class HouseTemplate {

    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House build");
    }

    private void buildFoundation(){
        System.out.println("template build foundation");
    }

    public abstract void buildPillars();

    public abstract void buildWalls();

    private void buildWindows(){
        System.out.println("template build windows");
    }
}
