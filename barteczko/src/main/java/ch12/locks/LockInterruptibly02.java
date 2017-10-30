package ch12.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly02 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable task1 = new Runnable() {
            public void run() {
                System.out.println("Task 1 begins");
                try {
                    lock.lockInterruptibly();//Możliwe jest przerwanie wątku zablokowanego na jakimś ryglu - za pomocą intrrupt()
                    //po wywołaniu intrrupt()   wątek nie będzie już posiadał rygla, więc lock.unlock() - rzuci wyjątek.
                    //należy sprawdzić, czy wątek posiada lock za pomocą metody - isHeldByCurrentThread()
                    System.out.println("Task 1 entered");
                    Thread.sleep(1000);
                } catch(InterruptedException exc) {
                    System.out.println("Task 1 interrupted");
                } finally {
                    lock.unlock();
                }
                System.out.println("Task 1 stopped");
            }
        };
        Thread thread = new Thread(task1);
        thread.start();
        thread.interrupt();//poleci wyjątek -
    }
}
