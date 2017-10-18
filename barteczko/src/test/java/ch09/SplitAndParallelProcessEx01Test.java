package ch09;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kkolcz on 11/10/17.
 */
public class SplitAndParallelProcessEx01Test {

    private StringBuilder word;
    private List<StringBuilder> wordList;
    SplitAndParallelProcessEx01 sappEx01;

    @Before
    public void setUp(){
        word = new StringBuilder("test");
        List<String> list = Arrays.asList("test","kot","ala");
        wordList = new ArrayList<>();
        for (String w : list) wordList.add(new StringBuilder(w));
        sappEx01 = new SplitAndParallelProcessEx01();
    }

    @Test
    public void testDoubleWordLetters(){
        sappEx01.doubleLetters(word);
        Assert.assertEquals("tteesstt",word.toString());
    }

    @Test
    public void testDoubleLettersForEveryWordInSpliterator(){
        sappEx01.doubleLettersForEveryWordInSpliterator(wordList.spliterator());
        Assert.assertEquals(3, wordList.size());
        Assert.assertEquals("tteesstt",wordList.get(0).toString());
        Assert.assertEquals("kkoott",wordList.get(1).toString());
        Assert.assertEquals("aallaa",wordList.get(2).toString());
    }
}
