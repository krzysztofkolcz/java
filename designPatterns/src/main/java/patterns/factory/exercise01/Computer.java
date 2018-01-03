package patterns.factory.exercise01;

public abstract class Computer {

    public abstract int getRAM();
    public abstract int getCPU();

    @Override
    public String toString() {
        return "Computer{} RAM:"+this.getRAM()+" CPU:"+this.getCPU();
    }
}
