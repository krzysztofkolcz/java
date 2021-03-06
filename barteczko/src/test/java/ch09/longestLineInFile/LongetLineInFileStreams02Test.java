package ch09.longestLineInFile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

public class LongetLineInFileStreams02Test {

    LongestLineInFileStreams02 longestLineInFileStreams02;
    String testDirPath = "longestLineTests/";

    public File getTestFile(String fileName){
        return getLocalFile(testDirPath+fileName);
        /*
        File f = longestLineInFileStreams02.getLocalFile(testDirPath+fileName);
        System.out.println(f.getAbsolutePath());
        return f;
        */
    }


    public File getLocalFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        return new File(url.getFile());
    }

    @Before
    public void setUp(){
        longestLineInFileStreams02 = new LongestLineInFileStreams02();
    }

    @Test
    public void textEmptyFile() {
        List<String> lines = longestLineInFileStreams02.getLongestLines(getTestFile("textEmptyFile.txt"));
        Assert.assertEquals(0,lines.size());
    }

    @Test
    public void textOneLongestLine(){
        List<String> lines = longestLineInFileStreams02.getLongestLines(getTestFile("textOneLongestLine.txt"));
        Assert.assertEquals(1,lines.size());
        Assert.assertEquals("one longest line",lines.get(0));
    }

    @Test
    public void textManyLongestLine(){
        List<String> lines = longestLineInFileStreams02.getLongestLines(getTestFile("textManyLongestLine.txt"));
        Assert.assertEquals(2,lines.size());
        Assert.assertEquals("longestline01",lines.get(0));
        Assert.assertEquals("longestline02",lines.get(1));
    }

    @Test
    public void textOneLine(){
        List<String> lines = longestLineInFileStreams02.getLongestLines(getTestFile("textOneLine.txt"));
        Assert.assertEquals(1,lines.size());
        Assert.assertEquals("one longetst line",lines.get(0));
    }

    @Test
    public void textOnlyLongestLines(){
        List<String> lines = longestLineInFileStreams02.getLongestLines(getTestFile("textOnlyLongestLines.txt"));
        Assert.assertEquals(2,lines.size());
        Assert.assertEquals("longestline01",lines.get(0));
        Assert.assertEquals("longestline02",lines.get(1));
    }
}
