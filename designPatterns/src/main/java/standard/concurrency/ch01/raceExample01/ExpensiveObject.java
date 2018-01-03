package standard.concurrency.ch01.raceExample01;

public class ExpensiveObject {
    public ExpensiveObject() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }
}
