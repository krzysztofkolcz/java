package patterns.memento.exercises02;

import org.junit.Assert;
import org.junit.Test;

public class FileWriterPackageTest {

    @Test
    public void testSaveAndUndo(){
        FileWriterUtil fileWriterUtil = new FileWriterUtil("fileName.txt",new StringBuilder("initial content"));
        FileWriterCaretaker fileWriterCaretaker = new FileWriterCaretaker();
        fileWriterCaretaker.save(fileWriterUtil);

        Assert.assertEquals("fileName.txt:initial content",fileWriterUtil.toString());

        fileWriterUtil.write("\n second line");
        fileWriterCaretaker.save(fileWriterUtil);
        Assert.assertEquals("fileName.txt:initial content\n second line",fileWriterUtil.toString());

        fileWriterUtil.write("\n third line");
        fileWriterCaretaker.save(fileWriterUtil);
        Assert.assertEquals("fileName.txt:initial content\n second line\n third line",fileWriterUtil.toString());
        fileWriterUtil.write("\n fourth line");

        fileWriterCaretaker.undo(fileWriterUtil);
        Assert.assertEquals("fileName.txt:initial content\n second line\n third line",fileWriterUtil.toString());

        fileWriterCaretaker.undo(fileWriterUtil);
        Assert.assertEquals("fileName.txt:initial content\n second line",fileWriterUtil.toString());

        fileWriterUtil.write("\n fourth line");
        fileWriterCaretaker.save(fileWriterUtil);
        Assert.assertEquals("fileName.txt:initial content\n second line\n fourth line",fileWriterUtil.toString());
    }
}
