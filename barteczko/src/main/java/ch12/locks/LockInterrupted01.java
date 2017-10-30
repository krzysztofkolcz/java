package ch12.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kkolcz on 30/10/17.
 */
public class LockInterrupted01 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable task1 = new Runnable() {
            public void run() {
                System.out.println("Task 1 begins");
                try {
                    lock.lock();
                    System.out.println("Task 1 entered");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Task 1 interrupted");
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                System.out.println("Task 1 stopped");
            }
        };
        Thread thread = new Thread(task1);
        thread.start();
        thread.interrupt();
    }
}
