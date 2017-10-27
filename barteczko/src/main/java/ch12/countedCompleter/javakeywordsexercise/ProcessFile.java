package ch12.countedCompleter.javakeywordsexercise;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.CountedCompleter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ProcessFile extends CountedCompleter<Map<String,Integer>> {

    public static List<String> keywords;

    String filePathName;
    Map<String,Integer> keywordCount;

    public ProcessFile(CountedCompleter<?> completer, String filePathName) {
        super(completer);
        this.filePathName = filePathName;
        keywordCount = new HashMap<>();
    }

    @Override
    public void compute() {
        System.out.println("Processing file:"+filePathName);
        Charset charset = Charset.forName("UTF-8");
        try (Stream<String> lines = Files.lines(Paths.get(filePathName),charset)) {
            keywordCount = FileUtil.fillMapWithKeywordCount(lines,keywords);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tryComplete();
    }

    @Override
    public void onCompletion(CountedCompleter<?> completer){
        System.out.println("Finished file:"+filePathName);
        MapUtil.printMap(keywordCount);
    }

    @Override
    public String toString(){
        return filePathName;
    }

    @Override
    public Map<String,Integer> getRawResult(){
        return keywordCount;
    }
}