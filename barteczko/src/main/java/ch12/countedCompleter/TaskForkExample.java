package ch12.countedCompleter;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by kkolcz on 26/10/17.
 */
public class TaskForkExample extends CountedCompleter<String>{
    private char thisTaskId;
    private int taskCount;
    private String result = "";

    public TaskForkExample(CountedCompleter<?> parent, char id, int taskCount ) {
        super(parent);
        thisTaskId = id;
        this.taskCount = taskCount;
    }
    @Override
    public void compute() {
        if (taskCount > 0) {
            char forkedId = (char) (thisTaskId + 1);
            setPendingCount(1);
            TaskForkExample toFork = new TaskForkExample(this, forkedId, --taskCount);
            toFork.fork();
        }
        // Obliczenia
        result = String.valueOf(thisTaskId);
        tryComplete();
    }
    @Override
    public String getRawResult() {
        return result;
    }
    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        System.out.println(this + " completed. Completion called by: " + caller);
        if (caller != this) result += caller.getRawResult();
    }
    @Override
    public String toString() {
        return "Task" + thisTaskId;
    }
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        String res = fjp.invoke(new TaskForkExample(null, 'A', 4));
        System.out.println("Result: " + res);
    }
}
