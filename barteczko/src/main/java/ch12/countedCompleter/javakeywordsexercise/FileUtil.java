package ch12.countedCompleter.javakeywordsexercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by kkolcz on 26/10/17.
 */
public class FileUtil {

    public static int countKeywordInLine(String keyword,String line){
        Pattern pattern = Pattern.compile("\\b"+keyword+"\\b");
        Matcher matcher = pattern.matcher(line);
        int keywordCount = 0;
        while(matcher.find()){
            keywordCount++;
        }
        return keywordCount;
    }


    public static Map<String,Integer> fillMapWithKeywordCount(Stream<String> lines,List<String> keywords){
        Map<String,Integer> keywordCount = new HashMap<>();
        lines.forEach( line -> {
            for(String keyword : keywords) {
                int count = FileUtil.countKeywordInLine(keyword, line);
                int current = Optional.ofNullable(keywordCount.get(keyword)).orElse(0);
                keywordCount.put(keyword, current + count);
            }
        });
        return keywordCount;
    }
}
