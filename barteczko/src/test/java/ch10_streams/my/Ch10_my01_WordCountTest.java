package ch10_streams.my;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Ch10_my01_WordCountTest {
    Ch10_my01_WordCount app;
    @Before
    public void setUp(){
        app = new Ch10_my01_WordCount();
    }

    @Test
    public void calculateWordCount() throws Exception {

        String line1 = "Humpty Dumpty sat on a wall";
        String line2 = "Humpty Dumpty had a great fall";
        String line3 = "Humpty bla bla bla";
        String[] array = {line1,line2,line3};
        List<String> lines = Arrays.asList(array);
        Map<String,Long> resultMap;
        resultMap = app.calculateWordCount(lines.stream());
        System.out.println(resultMap);
        Assert.assertTrue(resultMap.containsKey("Humpty"));
        Assert.assertEquals(3,resultMap.get("Humpty").intValue());

        Assert.assertTrue(resultMap.containsKey("bla"));
        Assert.assertEquals(3,resultMap.get("bla").intValue());
    }

    @Test
    public void getWordStreamFromLine() throws Exception {
        String line = "ala ma kota";
        Stream<String> stream = app.getWordStreamFromLine(line);
        List<String> words = stream.collect(Collectors.toList());

        Assert.assertTrue(words.contains("ala"));
        Assert.assertTrue(words.contains("ma"));
        Assert.assertTrue(words.contains("kota"));
    }

    @Test
    public void getWordStreamFromEmptyLine() throws Exception {
        String line = "";
        Stream<String> stream = app.getWordStreamFromLine(line);
        List<String> words = stream.collect(Collectors.toList());
        System.out.println(words);
        System.out.println(words.size());

        Assert.assertTrue(words.isEmpty());
    }

}