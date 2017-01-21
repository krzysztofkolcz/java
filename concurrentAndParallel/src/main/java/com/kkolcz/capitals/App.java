package com.kkolcz.capitals;

import java.util.*;
import java.util.stream.*;
import javax.swing.JOptionPane; 

public class App 
{
    public static void main( String[] args ) {
      Set<String> cap = new HashSet<>(Arrays.asList("praga","moskwa"));
      Set<String> entered = new HashSet<>(); //stolice już podane
      JOptionPane.showMessageDialog(null, "podaj stolice");
      int count = 0; //ile już podano
      Timer timer = new Timer();
      Thread tt = new Thread(timer);
      tt.start();
      for(int n = cap.size(); count<n;){
        String in = JOptionPane.showInputDialog("odpowiedzi: " + count + "/" + n + '\n' + "Wpisz kolejną stolicę:");
        if(in == null) break;
        in = in.toLowerCase();
        if(!entered.contains(in) && cap.contains(in)){
          count++;
          entered.add(in);
        }

      }
    }
}
