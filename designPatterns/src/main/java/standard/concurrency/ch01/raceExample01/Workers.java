package standard.concurrency.ch01.raceExample01;

public class Workers implements Runnable {

    private LazyInitRace lazyInitRace;
    private ExpensiveObject expensiveObject;

    public Workers(LazyInitRace lazyInitRace) {
        this.lazyInitRace = lazyInitRace;
    }

    @Override
    public void run() {
        expensiveObject = lazyInitRace.getInstance();
    }

    public ExpensiveObject getExpensiveObject() {
        return expensiveObject;
    }
}
