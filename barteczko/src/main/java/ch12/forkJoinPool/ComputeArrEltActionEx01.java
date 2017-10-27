package ch12.forkJoinPool;

import java.util.Random;
import java.util.concurrent.RecursiveAction;
import java.util.function.UnaryOperator;

public class ComputeArrEltActionEx01<T> extends RecursiveAction{
    private static int THRESHOLD;
    private static UnaryOperator operator;
    private T[] arr;
    private int from;
    private int to;


    public static void setThreshold(int threshold){
        THRESHOLD = threshold;
    }

    public static void setOperator(UnaryOperator op){
        operator = op;
    }

    public ComputeArrEltActionEx01(T[] arr){
        this(arr,0,arr.length);
    }

    private ComputeArrEltActionEx01(T[] arr,int from, int to){
        this.arr = arr;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void compute() {
        int mid = 0;
        if(to - from > THRESHOLD){
            mid = (from + to)/2;
            ComputeArrEltActionEx01<T> left = new ComputeArrEltActionEx01<>(arr,0,mid);
            ComputeArrEltActionEx01<T> right = new ComputeArrEltActionEx01<>(arr,mid,to);
            report("fork " + right);
            right.fork();
            report("invoke " + left);
            left.invoke();
            report("join " + right);
            right.join();
        }else{
            UnaryOperator<T> calc = ComputeArrEltActionEx01.operator;
            for(int i = from; i < to; i++){
                arr[i] = calc.apply(arr[i]);
            }
        }
    }

    public T[] getArr(){
        return arr;
    }

    public static void main(String[] args) {
        Double[] arr = generateArray(10,1,100);
        printArray(arr);
        System.out.println( );
        ComputeArrEltActionEx01.setThreshold(3);
        UnaryOperator<Double> op = e -> e+e;
        ComputeArrEltActionEx01.setOperator(op);
        ComputeArrEltActionEx01<Double> compute = new ComputeArrEltActionEx01<>(arr);
        compute.invoke();
        printArray(arr);
    }

    public static Double[] generateArray(int size,int min, int max){
        Double[] arr = new Double[size];
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            arr[i] = min + (max - min) * rand.nextDouble();
        }
        return arr;
    }

    public static void printArray(Double[] arr){
        for(Double d : arr){
            System.out.println(d);
        }
    }

    public void report(String msg) {
        System.out.println(this + "\t" + msg + "\t" + Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "[" + from + "," + (to-1) + "]";
    }
}
