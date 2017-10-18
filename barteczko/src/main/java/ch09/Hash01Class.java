package ch09;

/**
 * Created by kkolcz on 12/10/17.
 */
public class Hash01Class {

    private char ch;

    public Hash01Class(char ch) {
        this.ch = ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hash01Class that = (Hash01Class) o;

        return ch == that.ch;
    }

    @Override
    public int hashCode() {
        return ((int) ch - 1)%4;
    }

    public String toString(){
        return Character.toString(ch);
    }
}

