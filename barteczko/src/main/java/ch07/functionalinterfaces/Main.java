package ch07.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Banana",13.0d));
        itemList.add(new Item("Apple",15.0d));
        itemList.add(new Item("Orange",25.0d));
        itemList.add(new Item("Cucumber",20.0d));

        List<Item> findList = ManipulationMethods.findAll(itemList,n -> n.getPrice() > 15.0d);
        System.out.println();
        System.out.println("findList:");
        findList.forEach(System.out::println);

        Predicate<Item> predicate01 = n -> n.getPrice() > 10.0d;
        Predicate<Item> predicate02 = n -> n.getName().endsWith("e") ;
        List<Item> findList2 = ManipulationMethods.findAll(itemList,predicate01.and(predicate02));
        System.out.println();
        System.out.println("findList2:");
        findList2.forEach(System.out::println);

        /* interface Function */
        List<Double> transformList = ManipulationMethods.transform(itemList,n -> n.getPrice() );
        System.out.println();
        System.out.println("transformList:");
        transformList.forEach(System.out::println);

        Function<Item,Double> function01 = n -> n.getPrice();
        Function<Double,Integer> function02 = n -> n.intValue();
        List<Integer> transformList02 = ManipulationMethods.transform(itemList,function01.andThen(function02));
        System.out.println();
        System.out.println("transformList02:");
        transformList02.forEach(System.out::println);

        List<Integer> transformList03 = ManipulationMethods.transform(itemList,function02.compose(function01));
        System.out.println();
        System.out.println("transformList03:");
        transformList03.forEach(System.out::println);

        System.out.println();
        System.out.println("process:");
        ManipulationMethods.process(itemList,n -> n.setPrice(n.getPrice()+1) );
        itemList.forEach(System.out::println);


    }
}
