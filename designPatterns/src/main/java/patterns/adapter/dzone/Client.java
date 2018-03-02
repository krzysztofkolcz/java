package patterns.adapter.dzone;

import java.util.Arrays;

public class Client {

    public int[] sortPrimitive(){
        int[] numbers = new int[]{34, 2, 4, 12, 1};

        Arrays.stream(numbers).forEach(e-> System.out.println(e));

        Sorter sorter = new SortListAdapter();
        int[] sortedNumbers = sorter.sort(numbers);
        Arrays.stream(sortedNumbers).forEach(e-> System.out.println(e));
        return sortedNumbers;
    }

    public static void main(String[] args) {
        Client client = new Client();
        int[] sortedNumbers = client.sortPrimitive();
        Arrays.stream(sortedNumbers).forEach(e-> System.out.println(e));
        for (int i = 0; i< sortedNumbers.length; i++){
            System.out.println(sortedNumbers[i]);
        }
    }
}
