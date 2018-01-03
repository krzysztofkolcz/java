package patterns.chain.exercise01;

public class AbstractDispenser implements Dispenser{

    private Dispenser nextDispenser;
    private final int DENOMINATION;
    private int billNumber;

    public AbstractDispenser(int denomination) {
        DENOMINATION = denomination;
        this.billNumber = 0;
    }

    @Override
    public final void addNext(Dispenser dispenser) {
        this.nextDispenser = dispenser;
    }

    @Override
    public void process(Currency amount) {
        countBillNumber(amount);
        countRemiderAndProcessFurther(amount);
    }

    private void countBillNumber(Currency amount){
        if(amount.getAmount() >= DENOMINATION){
            this.billNumber = amount.getAmount() / DENOMINATION;
            System.out.println("Dispense " + this.billNumber + " " + DENOMINATION + "$ bills");
        }
    }

    private void countRemiderAndProcessFurther(Currency amount){
        int reminder = countReminder(amount);
        processFurther(reminder);
    }

    private int countReminder(Currency amount){
        return amount.getAmount() % DENOMINATION;
    }

    private void processFurther(int reminder){
        Currency restAmount;
        if(reminder > 0) {
            restAmount = new Currency(reminder);
            nextDispenser.process(restAmount);
        }
    }

    public int getBillNumber(){
        return this.billNumber;
    }
}
