package concurrentAndParallel.completion01;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;


public class FibTest extends TestCase {

    public FibTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( FibTest.class );
    }

    public void testFib0() {
      try{
        Fib fib = new Fib(0);
        assertEquals(Long.valueOf(0), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib1() {
      try{
        Fib fib = new Fib(1);
        assertEquals(Long.valueOf(1), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib2() {
      try{
        Fib fib = new Fib(2);
        assertEquals(Long.valueOf(1), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib3() {
      try{
        Fib fib = new Fib(3);
        assertEquals(Long.valueOf(2), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib4() {
      try{
        Fib fib = new Fib(4);
        assertEquals(Long.valueOf(3), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib5() {
      try{
        Fib fib = new Fib(5);
        assertEquals(Long.valueOf(5), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib6() {
      try{
        Fib fib = new Fib(6);
        assertEquals(Long.valueOf(8), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }

    public void testFib7() {
      try{
        Fib fib = new Fib(7);
        assertEquals(Long.valueOf(13), fib.getResult());
      }catch(Exception e){
        System.out.println(e); 
      }
    }
}

