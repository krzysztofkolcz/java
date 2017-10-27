package ch12.countedCompleter.javakeywordsexercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class FileUtilTest {

    @Test
    public void countKeywordInLineTest(){
        String keyword = "test";
        String line = "test 01 test02 test";
        int count = FileUtil.countKeywordInLine(keyword,line);
       assertEquals(2,count);
    }

    @Test
    public void countKeywordInLineTest0(){
        String keyword = "test";
        String line = "01 test02 bla bleadgao asgoiahw";
        int count = FileUtil.countKeywordInLine(keyword,line);
        assertEquals(0,count);
    }

    @Test
    public void countKeywordInLineTest1(){
        String keyword = "test";
        String line = "test";
        int count = FileUtil.countKeywordInLine(keyword,line);
        assertEquals(1,count);
    }

    @Test
    public void countKeywordInLineTest2(){
        String keyword = "test";
        String line = "test test";
        int count = FileUtil.countKeywordInLine(keyword,line);
        assertEquals(2,count);
    }

    @Test
    public void fillMapTest01(){
        List<String> keywords = Arrays.asList("public","static","void","package","int","for");
        List<String> list = Arrays.asList("public static void main(){",
                "int i = 1;",
                "System.out.println(i)",
                "}");
        Stream<String> stream = list.stream();
        Map<String,Integer> map = FileUtil.fillMapWithKeywordCount(stream,keywords);
        assertEquals(1,map.get("public").intValue());
        assertEquals(1,map.get("static").intValue());
        assertEquals(1,map.get("void").intValue());
        assertEquals(1,map.get("int").intValue());
        assertEquals(0,map.get("for").intValue());
    }

    @Test
    public void fillMapTest02(){
        List<String> keywords = Arrays.asList("public","static","void","package","int","for");
        List<String> list = Arrays.asList("public static void main(){",
                "int i = 1;",
                "System.out.println(i)",
                "}",
                "public void function(int b){",
                "for(int i = 0;i<b;i++){}",
                "}");
        Stream<String> stream = list.stream();
        Map<String,Integer> map = FileUtil.fillMapWithKeywordCount(stream,keywords);
        assertEquals(2,map.get("public").intValue());
        assertEquals(1,map.get("static").intValue());
        assertEquals(2,map.get("void").intValue());
        assertEquals(3,map.get("int").intValue());
        assertEquals(1,map.get("for").intValue());
    }
}
