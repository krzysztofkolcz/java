package patterns.adapter.dzone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortListAdapter implements Sorter{

    public List<Integer> convertArrayOfPrimitivesToListOfIntegers(int[] numbers){
        List<Integer> numberList = Arrays.stream(numbers).mapToObj(i -> new Integer(i)).collect(Collectors.toList());
        return numberList;
    }


    public int[] convertListOfIntegersToArrayOfPrimitives(List<Integer> list){
        int[] primitivesArray = new int[list.size()];
        primitivesArray = list.stream().mapToInt(Integer::intValue).toArray();
        return primitivesArray;
    }

    @Override
    public int[] sort(int[] numbers)   {      //convert the array to a List
        List<Integer> numberList = new ArrayList<Integer>(convertArrayOfPrimitivesToListOfIntegers(numbers));
        //call the adapter
        NumberSorter sorter = new NumberSorter();
        numberList = sorter.sort(numberList);
        numberList.stream().forEach(e-> System.out.println(e));
        //convert the list back to an array and return
        return convertListOfIntegersToArrayOfPrimitives(numberList);
    }

}
