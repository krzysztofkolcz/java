package standard.concurrency.ch02.novisibility;

public class NoVisibility01 {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
            ready = false;
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i<10000; i++) {
            new ReaderThread().start();
            number = i;
            ready = true;
        }
    }
}
