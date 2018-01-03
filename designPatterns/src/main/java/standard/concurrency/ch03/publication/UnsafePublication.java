package standard.concurrency.ch03.publication;

public class UnsafePublication {

    public static void main(String[] args) {
        Holder holder = new Holder(42);
        Worker01 worker01 = new Worker01(holder);
        try {
            Thread thread = new Thread(worker01);
            thread.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
