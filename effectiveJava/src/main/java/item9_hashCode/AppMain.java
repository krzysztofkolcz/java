package item9_hashCode;

import java.util.HashMap;
import java.util.Map;

public class AppMain {
    public static void main(String[] args) {
        Map<PhoneNumber, String> m
                = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        String result = m.get(new PhoneNumber(707 , 867 , 5309));
        System.out.println(result);

        Map<PhoneNumberWithHS, String> m2
                = new HashMap<PhoneNumberWithHS, String>();
        m2.put(new PhoneNumberWithHS(707, 867, 5309), "Jenny");
        result = m.get(new PhoneNumberWithHS(707 , 867 , 5309));
        System.out.println(result);
    }
}
