package ch12.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringTab {

    private String[] txt;
    private Lock lock = new ReentrantLock();

    public void set(int i, String s) {
        lock.lock();
        txt[i] = s;
        lock.unlock();
    }

    //Niepoprawne!!!
    //potencjalnie - ArrayIndexOutOfBoundsException i NullPointerException
    //wystąpienie wyjątku spowoduje, że lock nie zostanie otwarty.
    /*
    public String get(int i) {
        lock.lock();
        String t = txt[i];
        lock.unlock();
        return t;
    }
    */

    //Poprawne
    public String get(int i) {
        lock.lock();
        try {
            return txt[i];
        } finally {
            lock.unlock();
        }
    }
}
