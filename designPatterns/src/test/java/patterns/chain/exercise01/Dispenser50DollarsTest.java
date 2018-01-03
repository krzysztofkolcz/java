package patterns.chain.exercise01;

import org.junit.Assert;
import org.junit.Test;

public class Dispenser50DollarsTest {
    @Test
    public void test50DollarDispenser(){
        Dispenser50Dollars dispenser50Dollars = new Dispenser50Dollars();
        Currency currency = new Currency(100);
        dispenser50Dollars.process(currency);
        int billNumber = dispenser50Dollars.getBillNumber();
        Assert.assertEquals(2,billNumber);
    }

    @Test
    public void test20DollarDispenser(){
        Dispenser20Dollars dispenser20Dollars = new Dispenser20Dollars();
        Currency currency = new Currency(80);
        dispenser20Dollars.process(currency);
        int billNumber = dispenser20Dollars.getBillNumber();
        Assert.assertEquals(4,billNumber);
    }

    @Test(expected=NullPointerException.class)
    public void test20DollarDispenserSmall(){
        Dispenser20Dollars dispenser20Dollars = new Dispenser20Dollars();
        Currency currency = new Currency(10);
        dispenser20Dollars.process(currency);
        int billNumber = dispenser20Dollars.getBillNumber();
        Assert.assertEquals(0,billNumber);
    }

    @Test
    public void test10DollarDispenser(){
        Dispenser10Dollars dispenser10Dollars = new Dispenser10Dollars();
        Currency currency = new Currency(10);
        dispenser10Dollars.process(currency);
        int billNumber = dispenser10Dollars.getBillNumber();
        Assert.assertEquals(1,billNumber);
    }
}
