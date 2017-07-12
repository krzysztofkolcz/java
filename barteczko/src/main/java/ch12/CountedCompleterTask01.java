package ch12;

import java.util.concurrent.*;

public class CountedCompleterTask01 extends CountedCompleter<Void> {

	private char thisTaskId;
	private int taskCount;

	public CountedCompleterTask01(CountedCompleter<?> parent, char id, int taskCount ) {
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
      CountedCompleterTask01 toFork = new CountedCompleterTask01(this, forkedId, --taskCount);
      toFork.fork();
      System.out.println(toFork + " forked");
      // Obliczenia
      try { 
        Thread.sleep(100); 
      } catch (InterruptedException exc) { 
        exc.printStackTrace();
      }
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
    fjp.invoke(new CountedCompleterTask01(null, 'A', 4));
	}
}
