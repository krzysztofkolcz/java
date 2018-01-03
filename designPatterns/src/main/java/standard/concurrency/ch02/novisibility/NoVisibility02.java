package standard.concurrency.ch02.novisibility;

public class NoVisibility02 {

    private volatile static boolean ready;
    private volatile static int number;

    private static class ReaderThread extends Thread {
        private int i;

        public ReaderThread(int i){
            this.i = i;
        }

        public void run() {
            System.out.println("Thread:"+i+" start");
            while (!ready)
                Thread.yield();
            System.out.println(number);
            ready = false;
            System.out.println("Thread:"+i+" finished");
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i<1000; i++) {
            new ReaderThread(i).start();
            number = i;
            ready = true;
        }
    }
}
