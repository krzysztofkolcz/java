package collectionsExercise01;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class AppTest {


    @Test
    public void testStringArray(){
      int count = 3;
      String[] array = App.getStringArray(count);
      assertEquals(count,array.length);
    }
}
