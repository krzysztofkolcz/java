package oca.ch02;

public class Labels {

   public static void main(String args[]){
	   Labels l = new Labels(); 
	   l.breakLabel();
   }

	public void breakLabel() {

		int i = 0;
		loop :         // 1
		{
			System.out.println("Loop Lable line");
			try{
				for (  ;  true ;  i++ ){
					if( i >5) break loop;       // 2
				}
			}
			catch(Exception e){
				System.out.println("Exception in loop.");
			}
			finally{
				System.out.println("In Finally");      // 3
			}
		}
	}
	
	public void label001() {
		   int c = 0;
		   JACK: while (c < 8){
		       JILL: System.out.println(c);
		       if (c > 3) break JILL; else c++;//DOES NOT COMPILE
		   }
		}		
}
