package oca.ch06;

import java.io.IOException;

class MyException002 extends Exception{}

public class MethodWithoutException {

    public static void main(String[] args) throws Exception{       
    	//OK
    	try{          
    		amethod();          
    		System.out.println("try ");       
		}catch(Exception e){          
			System.out.print("catch ");       
		}finally{          
			System.out.print("finally ");       
		}       
    	System.out.print("out ");    

    	//OK
    	try {
    		amethod();
    	}catch(NullPointerException e) {
    	}
    	
		//DOES NOT COMPILE 
    	/*
    	try {
    		amethod();
    	}catch(IOException e) {
    	}
    	*/

		//DOES NOT COMPILE 
    	/*
    	try{          
    		amethod();          
    		System.out.println("try ");       
		}catch(MyException002 e){//DOES NOT COMPILE 
			//unreacheable block for MyException
			//this exception is never thrown from the try statement body
			System.out.print("catch ");       
		}	
		*/
	}    

    public static void amethod(){ } 
}