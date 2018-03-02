package ch05_generics.sub03;

public class GenericObject<T> {

    T value;

    public void setValue(T t){
        value = t;
    }

    public T getValue(){
        return value;
    }
}
