package ch09;

import java.util.*;
import java.util.function.Consumer;

/** Created by kkolcz on 11/10/17. */
public class ListsEx01 {

    private int operationCount;
    private int elementCount;
    private List<String> list;

    public int getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(int operationCount) {
        this.operationCount = operationCount;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    ListsEx01(int operationCount, int elementCount) {
        this.operationCount = operationCount;
        this.elementCount = elementCount;
    }

    public void generateList(int elementCount) {
        list = new ArrayList<>();
        for (int i = 0; i < elementCount; i++) list.add("a");
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return this.list;
    }

    public void measureAll() {
        long time01 = measure(list, this::insertAtOddPlace);
        showTime(time01);

        long time02 = measure(new LinkedList<>(list), this::insertAtOddPlace);
        showTime(time02);

        long time03 = measure(list, this::editElementAtRanodomPosition);
        showTime(time03);
        long time04 = measure(new LinkedList<>(list), this::editElementAtRanodomPosition);
        showTime(time04);

    }

    private void showTime(long time){
        double t = time / 1000;
        System.out.println("Linked List Edit time: ");
        System.out.format("%10.3f", t);
    }

    public long measure(List<String> list, Consumer<List<String>> oper) {
        long start = System.currentTimeMillis();
        oper.accept(list);
        long time = System.currentTimeMillis() - start;
        return time;
    }

    public void forEachTesting(List<String> list){
        int count = 0;
        list.forEach(e -> {
            if ("a".equals(e)) {

            }
        });
    }

    public void insertAtOddPlace(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        int i = 0;
        int count = 0;
        while (iterator.hasNext() && count < operationCount) {
            i++;
            count++;
            iterator.next();
            if (i % 2 != 0) {
                iterator.add("b");
            }
        }
    }

    public void editElementAtRanodomPosition(List<String> list){
        int listSize = list.size();
        Random random = new Random();
        int elementIndex;
        int count = 0;
        while(count < operationCount) {
            elementIndex = random.nextInt(listSize - 1);
            String element = list.get(elementIndex);
            element += "Bla";
            list.set(elementIndex, element);
            count++;
        }
    }

    public static void main(String[] args) {
        ListsEx01 listsEx01 = new ListsEx01(50000,50000);
        listsEx01.generateList(listsEx01.getElementCount());
        listsEx01.measureAll();
    }

    public void testingIterator(){
        List<String> ll = new ArrayList<String>();
        ll.add("x");
        ll.add("x");
        int i = 0;
        ListIterator<String> li = ll.listIterator();
        li.forEachRemaining(System.out::print);
        li = ll.listIterator();
        while(li.hasNext()){
            li.next();
            if (i % 2 != 0){
                li.add("X");
            }
            i++;
        }
        System.out.println();
        li = ll.listIterator();
        li.forEachRemaining(System.out::print);
        System.out.println();
        ll.forEach(System.out::print);
        System.out.println();
        List<String> l2 = new ArrayList<>();
        l2.add("a");
        l2.add("a");
        ListsEx01 listsEx01 = new ListsEx01(10,10);
        listsEx01.insertAtOddPlace(l2);
        l2.forEach(System.out::print);
    }
}
