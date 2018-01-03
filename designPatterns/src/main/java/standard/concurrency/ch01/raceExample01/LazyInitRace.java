package standard.concurrency.ch01.raceExample01;

public class LazyInitRace {
    private ExpensiveObject instance = null;
    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        System.out.println(instance);
        return instance;
    }
}

