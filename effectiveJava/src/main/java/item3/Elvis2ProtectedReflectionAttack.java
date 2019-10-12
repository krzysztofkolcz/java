package item3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Elvis2ProtectedReflectionAttack {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Elvis2Protected elvis = Elvis2Protected.INSTANCE;
        System.out.println(elvis);

        Constructor<Elvis2Protected> constructor;
        constructor = Elvis2Protected.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Elvis2Protected elvis2 = constructor.newInstance();
        System.out.println(elvis2);
    }
}
