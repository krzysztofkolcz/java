package patterns.chain.exercise01;

public interface Dispenser {

    public void addNext(Dispenser dispenser);
    public void process(Currency amount);
    public int getBillNumber();
}
