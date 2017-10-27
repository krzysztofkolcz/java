package ch12.executors;

import java.util.concurrent.Callable;

public class FibCall implements Callable<Long>{

    private static int N0 = 0;
    private static int N1 = 1;
    private int n;

    public FibCall(int n){
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
    public Long call() throws Exception {
        Long result = count(this.n);
        System.out.println(this.n + ":" + result);
        return result;
    }
}
