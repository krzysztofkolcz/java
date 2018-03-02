package item16_composition;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InstrumentedHashSetWrongTest {

    @Test
    public void addAll() throws Exception {
        InstrumentedHashSetWrong<String> s = new InstrumentedHashSetWrong<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        int count = s.getAddCount();
        System.out.println(count);
        System.out.println(s);
    }

}