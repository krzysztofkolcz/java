package ch12.forkJoinPool;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.function.UnaryOperator;

public class ComputeArrEltAction<T> extends RecursiveAction {
    private static int THRESHOLD; // próg rozmiaru tablicy
    private static UnaryOperator calc; // operacja do wykonania
    private T[] arr; // tablica
    private int from; // indeks początku tablicy
    private int to; // indeks końca tablicy
    // Ustalenie progu i operacji
    static void set(int threshold, UnaryOperator op) {
        THRESHOLD = threshold;
        calc = op;
    }
    public ComputeArrEltAction(T[] arr, int from, int to) {
        this.from = from;
        this.to = to;
        this.arr = arr;
    }
    @Override
    protected void compute() {
        if (to - from > THRESHOLD) { // podział tablicy, gdy jej rozmiar większy od progu
            int mid = from + (to - from)/2; // -> (from+to)/2 -> (from+to)>>>1
            ComputeArrEltAction<T> left = new ComputeArrEltAction<>(arr, from, mid);
            ComputeArrEltAction<T> right = new ComputeArrEltAction<>(arr, mid, to);
            right.fork(); // do wykonania asynchronicznego
            left.invoke(); // wywołuje compute()
            right.join(); // łączymy
        } else {
            // Obliczenia bezpośrednie
            // calc 
            UnaryOperator<T> calc = ComputeArrEltAction.calc;
            for (int i = from; i < to; i++) {
                arr[i] = calc.apply(arr[i]);
            }
        }
    }

    public T[] getArray(){
        return this.arr;
    }

    public static void main(String[] args) {
        int threshold = 2; // próg
        Double[] arr = generateArray(10,1,10000) ;
        printArray(arr);

        UnaryOperator<Double> op = e -> e+e;
        ComputeArrEltAction.set(threshold, op);
        ComputeArrEltAction task = new ComputeArrEltAction<Double>( arr, 0, arr.length );
        // Sposób 1
        ForkJoinPool fjp = new ForkJoinPool(4);
        fjp.invoke(task);
        // Sposób 2
        task.invoke();

        System.out.println("Results:");
        Double[] resultArr = (Double[]) task.getArray();
        printArray(resultArr);
    }

    public static Double[] generateArray(int size,int rangeMin, int rangeMax){
        Double[] array = new Double[size];
        Random r = new Random();
        for(int i = 0; i < size; i++){
            array[i] = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        }
        return array;
    }

    public static void printArray(Double[] array){
        for(Double d : array){
            System.out.println(d);
        }
    }
}