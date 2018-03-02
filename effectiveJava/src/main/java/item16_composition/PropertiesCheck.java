package item16_composition;

import java.util.Properties;

public class PropertiesCheck {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("a","aaa");
        String a = properties.getProperty("a");
        System.out.println(a);
        properties.put(new Integer(10),new Integer(10));
        Integer ten = (Integer)properties.get(new Integer(10));
        System.out.println(ten);
    }
}
