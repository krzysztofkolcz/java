package ch12.countedCompleter;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

public class Task extends CountedCompleter<Void> {
    private char thisTaskId;
    private int taskCount;
    public Task(CountedCompleter<?> parent, char id, int taskCount ) {
        super(parent);
        thisTaskId = id;
        this.taskCount = taskCount;
    }
    @Override
    public void compute() {
        System.out.println("Compute " + this);
        if (taskCount > 0) {
            char forkedId = (char) (thisTaskId + 1);
            setPendingCount(1);
            Task toFork = new Task(this, forkedId, --taskCount);
            toFork.fork();
            System.out.println(toFork + " forked");
            // Obliczenia
            try { Thread.sleep(100); } catch (InterruptedException exc) { }
        }
        tryComplete();
    }
    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        System.out.println(this + " completed. Completion called by: " + caller);
    }
    @Override
    public String toString() {
        return "Task" + thisTaskId;
    }
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(new Task(null, 'A', 4));
    }
}