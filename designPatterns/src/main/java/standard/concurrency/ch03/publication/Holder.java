package standard.concurrency.ch03.publication;

public class Holder {
    private int n;
    public Holder(int n) {
        try {
            Thread.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        this.n = n;
    }

    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
