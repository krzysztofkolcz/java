package ch10_streams.my;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Ch10_my01_WordCount {

    public Stream<String> getFile(String name){
        URL url = getClass().getClassLoader().getResource(name);
        try {
            Path path = Paths.get(url.toURI());
            Stream<String> stringStream = Files.lines(path);
            return stringStream;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String,Long> calculateWordCount(Stream<String> stringStream){
        Map<String,Long> map = new TreeMap<>();
        map = stringStream
                .flatMap( line -> getWordStreamFromLine(line))
                .collect(
                        Collectors.groupingBy( c -> c,Collectors.counting())
                );

        return map;

    }

    public Stream<String> getWordStreamFromLine(String line){
        return Arrays.stream(line.split("\\s+")).filter(s -> s.length() > 0);
    }

    public Stream<String> getWordStreamFromLine01(String line){
        Pattern pattern = Pattern.compile("\\s+");
        return pattern.splitAsStream(line).filter(s -> s.length() > 0);
    }

    public static void main(String[] args) {
        Ch10_my01_WordCount app = new Ch10_my01_WordCount();


    }
}
