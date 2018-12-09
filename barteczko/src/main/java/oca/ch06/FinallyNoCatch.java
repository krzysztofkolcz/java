package oca.ch06;

// Pamiętać o tym, że jeżeli nie ma catch, wyjatek nie jest obslużony
public class FinallyNoCatch {    
	public static void main(String args[]) throws Exception{        
		try{           
			m1();           
			System.out.println("A");        
		}finally{           
			System.out.println("B");        
		}        
		System.out.println("C");    
	}    

	public static void m1() throws Exception { throw new Exception(); } 
}

// print: 
// B
// Exception in thread "main" java.lang.Exception
//	at oca.ch06.FinallyNoCatch.m1(FinallyNoCatch.java:14)
//	at oca.ch06.FinallyNoCatch.main(FinallyNoCatch.java:6)