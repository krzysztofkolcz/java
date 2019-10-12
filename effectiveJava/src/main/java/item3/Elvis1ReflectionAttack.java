package item3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Elvis1ReflectionAttack {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Elvis1 elvis = Elvis1.INSTANCE;
        System.out.println(elvis);

        Constructor<Elvis1> constructor;
        constructor = Elvis1.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Elvis1 elvis2 = constructor.newInstance();
        System.out.println(elvis2);
    }
}
