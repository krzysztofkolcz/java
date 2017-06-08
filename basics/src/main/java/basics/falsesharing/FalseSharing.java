package basics.falsesharing;

public class FalseSharing {
  public static final long ITERATIONS = 500L * 1000L * 1000L;
  public static final Pojo POJO = new Pojo();

  public static void main(String[] args) throws InterruptedException {
    final long start = System.currentTimeMillis();
    final Thread xThread = new XThread();
    final Thread yThread = new YThread();
    xThread.start();
    yThread.start();
    xThread.join();
    yThread.join();
    final long duration = System.currentTimeMillis() - start;
    System.out.printf("Duration: %d ms", duration);
  }

  static class Pojo {

    public volatile long x;
    /* private long l1,l2,l3,l4,l5,l6,l7,l8; */
    public volatile long y;

  }

  static class XThread extends Thread {

    @Override
    public void run() {
      for (long i = 0; i < ITERATIONS; i++) {
        POJO.x = i;
      }
    }

  }

  static class YThread extends Thread {

    @Override
    public void run() {
      for (long i = 0; i < ITERATIONS; i++) {
        POJO.y = i;
      }
    }
    
  }

}
