package ch12.executors;

import java.util.concurrent.*;

public class ReverseString {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        String str = "Ala ma kota";
        Future<String> future = executorService.submit(() -> {
            char[] original = str.toCharArray();
            char[] reversed = new char[str.length()];
            int len = str.length();
            for(int i = 0; i < len; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reversed[i] = original[len - i - 1];
                System.out.println(reversed[i]);
            }
            return String.copyValueOf(reversed);
        });

        while(!future.isDone()){
            try {
                Thread.sleep(10);
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new FutureTask<Integer>(() -> new Integer(10)));
    }

}
