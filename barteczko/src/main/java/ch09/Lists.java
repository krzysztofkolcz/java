package ch09;

import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by kkolcz on 11/10/17.
 */
public class Lists {
    private int lsize; // rozmiar listy
    private int opCount; // liczba operacji (dostępu, dodawania itp.)

    public int measure(List<String> list, boolean transformToArrayList, Consumer<List<String>> oper) {
        final int COUNT = 3;
        long[] times = new long[COUNT];
        // wykonujemy COUNT razy, aby zebrać statystykę
        for (int i = 0; i < COUNT; i++) {
            long start = System.currentTimeMillis();
            if (transformToArrayList) list = new ArrayList<String>(list);
            oper.accept(list);
            times[i] = System.currentTimeMillis() - start;
        }
        double sum = 0;
        for (int i = 0; i < COUNT; i++) sum += times[i];
        return (int) (sum/COUNT);
    }

    public Lists(int lsize, int opCount) {
        this.lsize = lsize;
        this.opCount = opCount;
        System.out.println("Liczba elementów: " + lsize + ", liczba operacji: " + opCount);
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i < lsize; i++) list.add("a");
        System.out.println("Lista utworzona .. warmup ...");
        // warmup
        Double dummy;
        for (int i=1; i < 1000000; i++) dummy = ((double) i) *i;
        System.out.println(".. warmup end");
        System.out.println("Swobodny dostęp do ArrayList: " +
                measure(new ArrayList<>(list), false, this::randomAccess));
        System.out.println("Swobodny dostęp do LinkedList: " +
                measure(new LinkedList<>(list), false, this::randomAccess));
        System.out.println("Swobodny dostęp do LinkedList za pośrednictwem kopii w ArrayList: " +
                measure(new LinkedList<>(list), true, this::randomAccess));
        System.out.println("Wpisywanie na ArrayList: " +
                measure(new ArrayList<>(list), false, this::insert));
        System.out.println("Wpisywanie na LinkedList: " +
                measure(new LinkedList<>(list), false, this::insert));
        System.out.println("Wpisywanie na koniec LinkedList: " +
                measure(new LinkedList<>(list), false, this::insertAtEnd));
        System.out.println("Wpisywanie na koniec ArrayList: " +
                measure(new ArrayList<>(list), false, this::insertAtEnd));
    }

    private void insertAtEnd(List<String> list) {
        for (int i=0; i<opCount; i++) {
            list.add("c");
        }
    }

    void randomAccess(List<String> list) {
        Random rand = new Random();
        for (int i=0; i<opCount; i++) {
            int index = rand.nextInt(list.size());
            String s = list.get(index);
            s = s + "a";
            list.set(index, s);
        }
    }

    public void insert(List<String> list) {
        ListIterator<String> iter = list.listIterator();
        int i = 0;
        int count = 0;
        while (iter.hasNext() && count < opCount) {
            iter.next();
            if (i % 2 != 0){
                iter.add("b");
            }
            i++; count++;
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(JOptionPane.showInputDialog("LiczbaElt LiczbaOp"));
        new Lists(scan.nextInt(), scan.nextInt());
    }
}

