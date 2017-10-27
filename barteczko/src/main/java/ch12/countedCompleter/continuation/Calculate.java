package ch12.countedCompleter.continuation;

import java.util.concurrent.CountedCompleter;

public class Calculate extends CountedCompleter<String>{

    String result;
    DataProvider dataProvider;

    public Calculate(CountedCompleter<?> parent) {
        super(parent);
    }

    @Override
    public void compute() {
        dataProvider = new DataProvider(this);
        result = "Calculate result. ";
        setPendingCount(1);
        dataProvider.fork();
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller){
        result += (String)dataProvider.getRawResult();
    }

    @Override
    public String getRawResult(){
        return result;
    }

}
