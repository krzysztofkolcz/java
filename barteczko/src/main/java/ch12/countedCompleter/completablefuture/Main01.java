package ch12.countedCompleter.completablefuture;

/**
 * Created by kkolcz on 27/10/17.
 */
public class Main01 {

  public static void main(String[] args) {
      String[] konteksty = { "A", "B", "C" };
      for (String ctx : konteksty) {
          Calc c = new Calc(ctx);
          c.doOutput(c.calculate(c.getRate()));
      }
  }
}
