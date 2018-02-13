package basics;

import basics.finaltest.ClassOne;

public class App 
{

  public final ClassOne classOne = new ClassOne("test");

  public ClassOne getClassOne(){
    return this.classOne;
  }

    public static void main( String[] args )
    {
        App app = new App();
        System.out.println(app.getClassOne().getFieldOne());
        //możliwa modyfikacjia pól klasy final
        app.getClassOne().setFieldOne("test1");
        System.out.println(app.getClassOne().getFieldOne());
        //niemożliwa modyfikacja referencji
        //app.classOne = new ClassOne("test2"); //niemożliwe
    }
}
