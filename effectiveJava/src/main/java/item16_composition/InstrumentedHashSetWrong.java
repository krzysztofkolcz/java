package item16_composition;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSetWrong <E> extends HashSet<E> {

    // The number of attempted element insertions
    private int addCount = 0;
    public InstrumentedHashSetWrong() {
    }

    public InstrumentedHashSetWrong(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        System.out.println("add :"+e);
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        System.out.println("addAll :"+c);
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

}
