package ch09;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;

public class Ch09_9_17_MeasureListAccessTest {

    @Test
    public void testMeasureAverageTime(){
        int NUMBER_OF_OPERATIONS = 3;
        long operationTimes[] = new long[NUMBER_OF_OPERATIONS];
        operationTimes[0] = 1;
        operationTimes[1] = 4;
        operationTimes[2] = 10;
        double averageTime = Ch09_9_17_MeasureListAccess_01.measureAverageTime(operationTimes);
        Assert.assertThat(averageTime, closeTo(50l,0.1));

    }
}
