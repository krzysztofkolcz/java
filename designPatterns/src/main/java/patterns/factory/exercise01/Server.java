package patterns.factory.exercise01;

public class Server extends Computer{

    private int ram;
    private int cpu;

    public Server(int ram, int cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public int getRAM() {
        return this.ram;
    }

    @Override
    public int getCPU() {
        return this.cpu;
    }
}
