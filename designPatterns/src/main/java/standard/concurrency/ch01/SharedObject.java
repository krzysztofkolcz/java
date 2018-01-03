package standard.concurrency.ch01;

public class SharedObject {

    private int value = 0;
    /** Returns a unique value. */
    public int getNext() {
        value++;
        value--;
        return value;
    }
}
