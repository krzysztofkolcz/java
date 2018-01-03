package standard.concurrency.ch02.novisibility;

public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        private String name;

        public ReaderThread(String name) {
            this.name = name;
        }

        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println("Thread "+name+" finished");
            System.out.println(number);
            ready = false;
        }
    }
    public static void main(String[] args) {
        for(int i = 0 ; i< 1000; i++) {
            new ReaderThread(String.valueOf(i)).start();
            number = i;
            ready = true;
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
