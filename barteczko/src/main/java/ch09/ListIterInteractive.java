package ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by kkolcz on 12/10/17.
 */
public class ListIterInteractive {

    private List<String> list;
    private ListIterator<String> iterator;
    private final static String movePrevious = "p";
    private final static String moveNext = "n";
    private final static String insert = "i";
    private final static String remove = "r";
    private final static String end = "end";
    private final static String print = "prt";
    private final static String description = movePrevious +" - move previous"
    +", " + moveNext +" - move next"
    +", " + insert +" - insert"
    +", " + remove +" - remove"
    +", " + print +" - print list"
    +", " + end +" - finish program";

    public static void main(String[] args) {
        ListIterInteractive listIterInteractive = new ListIterInteractive();
    }

    public ListIterInteractive(){
        list = new ArrayList<>();
        iterator = list.listIterator();
        while (inputFromConsole() != 0) {
        }
    }


    private int inputFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(description);
        System.out.print("command:");
        try {
            String command = br.readLine();
            if(insert.equals(command)) {
                System.out.print("insert:");
                String insert = br.readLine();
                iterator.add(insert);
                printList();
                return 1;
            }else if(remove.equals(command)){
                if(list.size() > 0) {
                    iterator.remove(); //jak przejdę iteratorm na początek listy, dodam element, a następnie wywołaam remove - leci IllegalStateException
                }else{
                    System.out.println("list empty");
                }
                printList();
                return 1;
            }else if(end.equals(command)){
                return 0;
            }else if(movePrevious.equals(command)){
                if(iterator.hasPrevious()) {
                    iterator.previous();
                }else{
                    System.out.println("cant move back");
                }
                printList();
                return 1;
            }else if(moveNext.equals(command)){
                if(iterator.hasNext()) {
                    iterator.next();
                }else{
                    System.out.println("cant move forward");
                }
                printList();
                return 1;
            }else if(print.equals(command)){
                printList();
                return 1;
            }else{
                System.out.println(command);
                return 1;
            }
        } catch (IOException e) {
            System.out.print("Error reading");
            System.out.print(description);
            return 1;
        }
    }

    private void printList(){
//        System.out.println(list);
        System.out.println();
        ArrayList<String> tmpList = new ArrayList<>(list);
        for(int i = 0; i < iterator.nextIndex(); i++){
            System.out.print(tmpList.get(i));
            System.out.print(" ");
        }
        System.out.print("|");
        for(int i = iterator.nextIndex(); i < list.size(); i++){
            System.out.print(tmpList.get(i));
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("prev:"+iterator.previousIndex());
        System.out.println(" next:"+iterator.nextIndex());
        System.out.println();
    }



}
