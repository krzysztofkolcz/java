package patterns.chain.exercise01;

public class ATM {
    private Dispenser firstDispenserInChain;

    public ATM() {
        firstDispenserInChain = new Dispenser50Dollars();
        Dispenser secondDispencerInChain = new Dispenser20Dollars();
        Dispenser thirdDispencerInChain = new Dispenser10Dollars();
        firstDispenserInChain.addNext(secondDispencerInChain);
        secondDispencerInChain.addNext(thirdDispencerInChain);
    }

    public void dispence(Currency amount) throws Exception{
        if(amount.getAmount() % 10 != 0){
           throw new Exception("amount should be divided by 10");
        }

        firstDispenserInChain.process(amount);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        try {
            atm.dispence(new Currency(230));
        }catch(Exception e){
            String msg= e.getMessage();
            System.out.println(msg);
        }
    }
}
