package ch05_generics.sub05_universal;

public class Para<S,T> {
    S first;
    T last;

    public Para() {
    }

    public Para(S s, T t) {
        this.first = s;
        this.last = t;
    }

    public S getFirst() {
        return first;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Para{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
