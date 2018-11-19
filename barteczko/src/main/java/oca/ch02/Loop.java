package oca.ch02;

public class Loop {

	 private int j;     
	 void showJ(){         
		 while(j<=5){             
			 System.out.println("j:"+j);
			 System.out.println();
			 for(int j=1; j <= 5;){                 
				 System.out.print(j+" ");                 
				 j++;             
			 }             
			 j++;         
		 }     
	 }     

	 public static void main(String[] args) {         
		 new Loop().showJ();     
	 } 
 }