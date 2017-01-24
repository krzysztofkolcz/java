package com.kkolcz.capitals;

import java.util.*;
import java.util.stream.*;
import javax.swing.JOptionPane; 

public class Timer implements Runnable{
  public void run(){
    int time=0;
    while(true){
      try{
        Thread.sleep(1000);
      }catch(InterruptedException exc){
        System.out.println("Wątek zliczania czasu został przerwany");
        return;
      }
      time++;
      int minutes = time/60;
      int sec = time%60;
      System.out.println(minutes+":"+sec);
    }
  }
}
