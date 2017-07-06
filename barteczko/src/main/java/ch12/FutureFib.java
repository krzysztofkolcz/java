package ch12;

import java.util.concurrent.*;

class FutureFib extends FutureTask<Long> {
  private Callable<Long> proc;
  public FutureFib(Callable<Long> proc) {
    super(proc);
    this.proc = proc;
  }
  protected void done() {
    String msg = "Wynik " + proc + " = ";
    if (this.isCancelled()) msg += " ... zadanie anulowane";
    else try {
      msg += this.get();
    } catch (InterruptedException | ExecutionException exc) {
      msg += " ... powstał wyjątek " + exc;
    }
    System.out.println(msg);
  }
}
