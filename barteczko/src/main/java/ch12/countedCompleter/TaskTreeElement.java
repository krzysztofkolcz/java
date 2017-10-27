package ch12.countedCompleter;

import java.util.concurrent.CountedCompleter;

public class TaskTreeElement extends CountedCompleter<Void> {

    @Override
    public void compute() {

    }

    @Override
    public void onCompletion(CountedCompleter<?> caller){
        System.out.println(this + " completed. Completion called by: " + caller);
    }
}
