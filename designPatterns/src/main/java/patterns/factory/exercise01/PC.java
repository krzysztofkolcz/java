package patterns.factory.exercise01;

public class PC extends Computer{

    private int ram;
    private int cpu;

    public PC(int ram, int cpu) {
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
