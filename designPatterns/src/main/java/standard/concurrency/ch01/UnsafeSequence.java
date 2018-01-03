package standard.concurrency.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//@NotThreadSafe
public class UnsafeSequence implements Runnable{
    private SharedObject sharedObject;
    private int whileCount = 0;

    public UnsafeSequence(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        try {
            int next = sharedObject.getNext();
            while (next == 0) {
                next = sharedObject.getNext();
                Thread.sleep(0);
                whileCount++;
            }
            System.out.println("next:"+next+"; whileCount:"+whileCount);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Future> futureList = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        SharedObject sharedObject = new SharedObject();
        Future f ;
        for(int i = 0; i < 100; i++){
           f = executor.submit(new UnsafeSequence(sharedObject));
           futureList .add(f);
        }

        while(futureList.size() > 0){
            for(int i = 0; i < futureList.size(); i++){
                f = futureList.get(i);
                if(f.isDone()){
                    futureList.remove(f);
                }
            }
            /*
            futureList.stream().forEach( n -> {
                        if (n.isDone()) {
                            futureList.remove(n);
                        }
                    }
                );
                */
        }

        System.out.println("Finished");
        executor.shutdown();

    }
}

