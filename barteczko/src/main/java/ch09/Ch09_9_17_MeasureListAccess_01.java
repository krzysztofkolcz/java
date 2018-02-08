package ch09;

import java.util.*;
import java.util.function.Consumer;

public class Ch09_9_17_MeasureListAccess_01 {
    static int NUMBER_OF_OPERATIONS = 10;
    static int NUMBER_OF_LIST_ELEMENTS = 20000000;

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        Ch09_9_17_MeasureListAccess_01.fillList(linkedList);
        Ch09_9_17_MeasureListAccess_01.fillList(arrayList);
//        linkedList.forEach(System.out::println);
//        double time = measureListAccessTime(linkedList,false,Ch09_9_17_MeasureListAccess_01::insertAtTheEnd);
//        System.out.println("LinkedList; Insert at the end; Time:"+time);

//        double timeLLARand = measureListAccessTime(linkedList,false,Ch09_9_17_MeasureListAccess_01::randomAccess);
//        System.out.println("LinkedList; Random access; Time:"+timeLLARand);

//        double timeLLIRand = measureListAccessTime(linkedList,false,Ch09_9_17_MeasureListAccess_01::insertAtRandomPositin);
//        System.out.println("LinkedList; Random insert; Time:"+timeLLIRand);

//        double time01 = measureListAccessTime(arrayList,false,Ch09_9_17_MeasureListAccess_01::insertAtTheEnd);
//        System.out.println("ArrayList; Insert at the end; Time:"+time01);

//        double time01LLARand = measureListAccessTime(arrayList,false,Ch09_9_17_MeasureListAccess_01::randomAccess);
//        System.out.println("ArrayList; Random access; Time:"+time01LLARand);

//        double time01LLIRand = measureListAccessTime(arrayList,false,Ch09_9_17_MeasureListAccess_01::insertAtRandomPositin);
//        System.out.println("ArrayList; Random insert; Time:"+time01LLIRand);

        System.out.println("ArrayList; Loop for; Time:"+
                measureListAccessTime(arrayList,false, Ch09_9_17_MeasureListAccess_01::loopForAccessTime)
                );

        System.out.println("LinkedList; Loop for; Time:"+
                measureListAccessTime(arrayList,false, Ch09_9_17_MeasureListAccess_01::loopForAccessTime)
            );

        System.out.println("ArrayList; Loop iteration; Time:"+
                measureListAccessTime(arrayList,false, Ch09_9_17_MeasureListAccess_01::loopIteratorAccessTime)
        );

        System.out.println("LinkedList; Loop iteration; Time:"+
                measureListAccessTime(arrayList,false, Ch09_9_17_MeasureListAccess_01::loopIteratorAccessTime)
        );
    }

    public static void fillList(List<Integer> list){
        Random random = new Random();
        for(int i = 0; i< NUMBER_OF_LIST_ELEMENTS; i++) {
            list.add(random.nextInt());
        }
    }

    public static double measureListAccessTime(List<Integer> list, boolean projectToArrayList, Consumer<List<Integer>> oper){
        List<Integer> worklist = list;
        if(projectToArrayList){
            worklist = new ArrayList<>(list);
        }
        long startTime;
        long operationTimes[] = new long[NUMBER_OF_OPERATIONS];
        for(int i = 0; i < NUMBER_OF_OPERATIONS; i++){
            startTime = System.currentTimeMillis();
            oper.accept(worklist);
            operationTimes[i] = System.currentTimeMillis() - startTime;
        }
        return measureAverageTime(operationTimes);
    }

    public static long measureAverageTime(long operationTimes[]){
        OptionalDouble averageTime = Arrays.stream(operationTimes).average();
        if(averageTime.isPresent()){
            return (long)averageTime.getAsDouble();
        }
        return 0;
    }

    public static void insertAtTheEnd(List<Integer> list){
        list.add(800);
    }

    public static void randomAccess(List<Integer> list){
        Random random = new Random();
        int elmentIndex = random.nextInt(list.size());
        Integer element = list.get(elmentIndex);
    }

    public static void insertAtRandomPositin(List<Integer> list){
        Random random = new Random();
        int elementIndex = random.nextInt(list.size());
        list.set(elementIndex,elementIndex);
    }

    public static void loopForAccessTime(List<Integer> list){
        Integer element;
        for(int i = 0; i < list.size(); i++){
            element = list.get(i);
        }
    }


    public static void loopIteratorAccessTime(List<Integer> list){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
    }
}
