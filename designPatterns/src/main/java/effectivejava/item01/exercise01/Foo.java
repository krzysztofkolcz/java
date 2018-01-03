package effectivejava.item01.exercise01;

import java.util.EnumSet;

public class Foo {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Foo)) return false;

        Foo foo = (Foo) o;

        if (!enumSet.equals(foo.enumSet)) return false;
        return name.equals(foo.name);
    }

    @Override
    public int hashCode() {
        int result = enumSet.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    private EnumSet enumSet;
    private String name;
}
