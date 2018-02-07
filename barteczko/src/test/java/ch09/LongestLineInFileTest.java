package ch09;

import ch09.longestLineInFile.LongestLineInFile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


/**
 * Created by kkolcz on 10/10/17.
 */
public class LongestLineInFileTest {

    private LongestLineInFile llif;
    private List<String> lines;
    private List<String> emptyLines;
    private List<String> oneLine;
    private List<String> manyLongest;

    @Before
    public void setUp(){
        llif = new LongestLineInFile();
        lines = Arrays.asList(
                        "line1","line22","line333","line4444"
        );
        emptyLines = new ArrayList<>();
        oneLine = Arrays.asList("oneLine");
        manyLongest = Arrays.asList("short","short","short","longline1","longline2","longline3","longline4");
    }

    @Test
    public void testFindLongestLine(){
        List<String> longest = llif.getLongestLinesFromFile(lines);
        assertEquals(longest.size(),1);
        assertEquals(longest.get(0),"line4444");
        longest.stream().forEach(System.out::println);
    }

    @Test
    public void testEmptyLines(){
        List<String> longest = llif.getLongestLinesFromFile(emptyLines);
        assertEquals(longest.size(),0);
    }

    @Test
    public void testOneLine(){
        List<String> longest = llif.getLongestLinesFromFile(oneLine);
        assertEquals(longest.size(),1);
        assertEquals(longest.get(0),"oneLine");
    }

    @Test
    public void testManyLongest(){
        List<String> longest = llif.getLongestLinesFromFile(manyLongest);
        assertEquals(longest.size(),4);
        assertEquals(longest.get(0),"longline1");
        assertEquals(longest.get(1),"longline2");
        assertEquals(longest.get(2),"longline3");
        assertEquals(longest.get(3),"longline4");
    }

}
