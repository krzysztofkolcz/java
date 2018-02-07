package ch09.longestLineInFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LongestLineInFileStreams02 {

    public List<String> getLongestLines(File file){
        List<String> longestLines01 = new ArrayList<>(Arrays.asList(""));
        int longestLineLength = 0;
        Path paths = Paths.get(file.toURI());
        try {
            Stream<String> stream = Files.lines(paths);
            int longest = stream.mapToInt(x -> x.length()).reduce(0, (x,y) -> x > y ? x : y);
            Stream<String> stream01 = Files.lines(paths);
            stream01.forEach(
               e -> {
                  if(e.length() > longestLines01.get(0).length()){
                      longestLines01.clear();
                      longestLines01.add(e);
                  }else if(e.length() == longestLines01.get(0).length()){
                      longestLines01.add(e);
                  }
               }
            );
            if(longestLines01.get(0).length()==0){
                longestLines01.remove(0);
            }
            return longestLines01;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
