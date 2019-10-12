package item11_clone;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {

    @Test
    public void cloneTest(){
       PhoneNumber phoneNumber = new PhoneNumber(71,321,987);
       PhoneNumber phoneNumberClone = phoneNumber.clone();
        Assert.assertNotSame(phoneNumber,phoneNumberClone);
        Assert.assertEquals(phoneNumber,phoneNumberClone);
        System.out.println(phoneNumber);
        System.out.println(phoneNumberClone);
        Assert.assertFalse(phoneNumber == phoneNumberClone);
    }
}
