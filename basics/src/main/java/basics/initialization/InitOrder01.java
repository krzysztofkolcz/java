package basics.initialization;

public class InitOrder01{

  private static int s = 100;
  private static int x;  // inicjalizowana na 0
  private static final int C;

  private int a = 1;

  InitOrder01(){
    report("Konstruktor");
    report("s = ",s);
    report("x = ",x);
    report("C = ",C);
    report("a = ",a);
    report("b = ",b);
  }


  private int b =  2;

  {
    report("Blok inicjacyjny:");
    report("s = ",s);
    report("x = ",x);
    report("C = ",C);
    report("a = ",a);
    report("b = ",b);

  }

  static{
    report("Statyczny blok inicjacyjny:");
    report("s = ",s);
    report("x = ",x);
    /* report("C =",C); */ // niezainicjalizowana
    /* report("a =",a); */ // Zmienne niestatyczne
    /* report("b =",b); */ // Zmienne niestatyczne
    C = 101;

  }
  private static void report(String msg, int ... args){
    System.out.print(msg + "");
    for(int i : args){
      System.out.print(i + "");
    }
    System.out.println();

  }

  public static void main(String[] args){
    report("metoda main");
    new InitOrder01();
  }
  
}

