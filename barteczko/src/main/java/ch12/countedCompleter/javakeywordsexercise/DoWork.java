package ch12.countedCompleter.javakeywordsexercise;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

public class DoWork extends CountedCompleter<Void>{

    private String startDir;
    private ProcessDir processDir;

    public DoWork(CountedCompleter<?> completer,String startDir) {
        super(completer);
        this.startDir = startDir;
    }

    @Override
    public void compute() {
        setPendingCount(1);
        processDir = new ProcessDir(this,startDir);
        processDir.fork();
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller){
        System.out.println("Finished DoWork");

        Map<String,Integer> result = processDir.getRawResult();
        printResultMap(result);


    }

    private void printResultMap(Map<String,Integer> result){
        for(Map.Entry<String,Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + ":"+ entry.getValue());
        }
    }

    public static void main(String[] args) {
        ProcessFile.keywords = Arrays.asList(
                "public","static","void","import","package"
        );
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        DoWork doWork = new DoWork(null,"/home/kkolcz/IdeaProjects/java/nettyUdp");
        forkJoinPool.invoke(doWork);

    }

}
