package ch12.countedCompleter.javakeywordsexercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountedCompleter;
import java.util.stream.Stream;

public class ProcessDir extends CountedCompleter<Map<String,Integer>> {

    private String dir;
    List<ProcessFile> files;
    List<ProcessDir> directories;
    Map<String,Integer> keywordCount;

    public ProcessDir(CountedCompleter<?> completer, String dir) {
        super(completer);
        this.dir = dir;
        files = new ArrayList<>();
        directories = new ArrayList<>();
        keywordCount = new HashMap<>();
    }

    @Override
    public void compute() {
        System.out.println("Start processing dir:"+dir);
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            stream.filter(path -> path.toString().toLowerCase().endsWith(".java") || Files.isDirectory(path)).forEach( p -> {
                if(Files.isDirectory(p)){
                    directories.add(new ProcessDir(this,p.toString()));
                }else if(Files.isRegularFile(p)){
                    files.add(new ProcessFile(this,p.toString()));
                }
            });
            setPendingCount(files.size() + directories.size());
            for(ProcessDir processDir : directories){
                processDir.fork();
            }
            for(ProcessFile processFile : files){
                processFile.fork();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> completer){
        System.out.println("Finised processing dir:"+dir);
        for(ProcessDir processDir : directories){
            System.out.println(processDir.getDir());
            keywordCount = MapUtil.mergeTwoMaps(processDir.getRawResult(),keywordCount);
//            MapUtil.printMap(processDir.getRawResult());
        }
        for(ProcessFile processFile : files){
            System.out.println(processFile.filePathName);
            keywordCount = MapUtil.mergeTwoMaps(processFile.getRawResult(),keywordCount);
//            MapUtil.printMap(processFile.getRawResult());
        }
    }

    public String getDir(){
        return dir;
    }

    @Override
    public Map<String,Integer> getRawResult(){
        return keywordCount;
    }
}