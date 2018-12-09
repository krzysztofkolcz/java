package oca.ch06;

public class FinallyNo2 {    
	public static void main(String args[]) throws Exception{        
		try {
			try{           
				m1();           
				System.out.println("A");        
			}finally{           
				System.out.println("B");        
			}        
			System.out.println("C");    
		}catch(Exception e) {
			System.out.println("D");    
		}
	}    

	public static void m1() throws Exception { throw new Exception(); } 
}

// print: 
// B
// D