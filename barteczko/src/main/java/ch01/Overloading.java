package ch01;

import java.util.List;

public class Overloading {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        ClassC classC = new ClassC();
        method(classA);
        method(classB);
        method(classC);
    }

    public static void method(ClassA a){
        System.out.println("method(ClassA a)");
    }

    public static void method(ClassB b){
        System.out.println("method(ClassB b)");
    }

    public static void methodList(List<ClassA> list){

    }

    /*
    //niemożliwe:
    public static void methodList(List<ClassB> list){
    }
    */

    public void methodException() throws EnumConstantNotPresentException{

    }

    /*
    //niemożliwe:
    public void methodException() throws IllegalArgumentException{
    }
    */

}
