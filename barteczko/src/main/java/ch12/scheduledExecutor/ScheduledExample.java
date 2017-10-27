package ch12.scheduledExecutor;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * Created by kkolcz on 25/10/17.
 */
public class ScheduledExample {

    public static void main(String[] args) throws Exception{
        Runnable rtask = () -> System.out.println("Executed at : " + LocalTime.now());
        Callable<String> ctask = () -> "Was executed at : " + LocalTime.now();
        ScheduledExecutorService s = Executors.newScheduledThreadPool(3);
        //schedule - uruchamia zadanie jednokrotnie po podanym czasie
        ScheduledFuture<?> sf = s.schedule(ctask, 1, TimeUnit.SECONDS);
        long delay = sf.getDelay(TimeUnit.MILLISECONDS);//delay:999
        String result = (String) sf.get();//result:Was executed at : 10:52:16.300
        //ScheduleWithFixedDelay uruchamia zadanie po podanym czasie i ponawia co podany okres
        //Dopóki nie ma cancel lub shutdown
        sf = s.scheduleWithFixedDelay(rtask, 1000, 500, TimeUnit.MILLISECONDS);
        Thread.sleep(3000);
        sf.cancel(false);
        //Zadanie zlecone przez scheduleWithFixedDelay - anulowane
        //ScheduleAtFixedRate uruchamia zadanie po podanym czasie i ponawia z zadaną częstotliwością
        //Dopóki nie ma cancel lub shutdown
        sf = s.scheduleAtFixedRate(rtask, 0, 1, TimeUnit.SECONDS);
        Thread.sleep(4000);
        s.shutdown();

        //Callable c = Executors.callable(Runnable t);
        Callable c = Executors.callable(rtask);
        //Callable c2 = Executors.callable(Runnable t, T r)
        String r = "a";
        Callable c2 = Executors.callable(rtask,r);
    }
}
