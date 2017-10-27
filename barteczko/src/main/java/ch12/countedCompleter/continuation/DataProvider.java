package ch12.countedCompleter.continuation;

import java.util.concurrent.CountedCompleter;

public class DataProvider extends CountedCompleter<String> {

    String result;

    public DataProvider(CountedCompleter<?> parent) {
        super(parent);
    }

    @Override
    public void compute() {
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller){
        this.result = "Data Provider Result";
    }

    @Override
    public String getRawResult(){
        return result;
    }
}
