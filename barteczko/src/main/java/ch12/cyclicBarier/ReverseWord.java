package ch12.cyclicBarier;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class ReverseWord implements Runnable {
    private List<String> wordChars; // lista liter w słowie
    private CyclicBarrier b; // bariera
    private String word; // przetwarzane słowo
    public ReverseWord(List<String> clist, CyclicBarrier b) {
        this.wordChars = clist;
        this.word = String.join("",clist);
        this.b = b;
    }
    @Override
    public void run() {
        System.out.println("Thread for: " + word + " - working");
        try {
            Thread.sleep(100);
            Collections.reverse(wordChars);
            System.out.println("Thread for: " + word + " - waiting on the barrier");
            b.await();
            System.out.println("Thread for: " + word + " - work continue " +
                    "after passing the barrier");
            Thread.sleep(100);
            Collections.reverse(wordChars);
            System.out.println("Thread for: " + word + " - again waiting on the barrier");
            b.await();
            System.out.println("Thread for: " + word + " - passed the barrier second time");
        } catch (BrokenBarrierException exc) {
            System.out.println("broken");
        } catch (InterruptedException exc) {
            System.out.println("interrupted");
        }
    }
}