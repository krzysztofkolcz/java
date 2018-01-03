package patterns.factory.exercise01;

public class ComputerFactory {

    public static Computer getComputer(String name, int ram, int cpu){
        if("PC".equals(name)){ return new PC(ram,cpu);
        }else if("Server".equals(name)){ return new Server(ram,cpu); }
        return null;
    }
}
