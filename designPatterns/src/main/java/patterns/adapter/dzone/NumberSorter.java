package patterns.adapter.dzone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSorter{

    public List<Integer> sort(List<Integer> numbers)   {      //sort and return
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        Collections.sort(numbersCopy);
        return numbersCopy;
    }

}
