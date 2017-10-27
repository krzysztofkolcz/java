package ch12.executors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by kkolcz on 24/10/17.
 */
public class FibCallMap implements Callable<Map<Integer,Long>> {
    private static int N0 = 0;
    private static int N1 = 1;
    private int n;

    public FibCallMap(int n){
        this.n = n;
    }

    private Long count(int n){
        int n_1 = N1;
        int n_2 = N0;
        int tmp;
        for(int i = 2; i <= n; i++){
            tmp = n_1;
            n_1 = n_1 + n_2;
            n_2 = tmp;
        }
        return new Long(n_1);
    }

    @Override
    public Map<Integer,Long> call() throws Exception{
        Long fibResult = count(this.n);
        Map<Integer,Long> result = new HashMap<>();
        result.put(this.n,fibResult);
        return result;
    }
}
