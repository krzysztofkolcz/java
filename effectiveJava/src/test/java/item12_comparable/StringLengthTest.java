package item12_comparable;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StringLengthTest {

    @Test
    public void orderTest(){
        StringLength sl1 = new StringLength("a");
        StringLength sl2 = new StringLength("aa");
        StringLength sl3 = new StringLength("aaa");
        StringLength sl4 = new StringLength("aa");
        StringLength[] array = new StringLength[4];
        array[0] = sl3;
        array[1] = sl2;
        array[2] = sl4;
        array[3] = sl1;
        Arrays.sort(array);
        for(StringLength a : array){
            System.out.println(a.getString());
        }
        Assert.assertEquals(array[0],sl1);
        Assert.assertEquals(array[3],sl3);

    }
}
