package standard.concurrency.ch03.publication;

public class Worker01 implements Runnable {
    private Holder holder;

    public Worker01(Holder holder) {
        this.holder = holder;
    }
    @Override
    public void run() {
        this.holder.assertSanity();
    }
}
