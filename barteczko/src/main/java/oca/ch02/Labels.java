package oca.ch02;

public class Labels {

   public static void main(String args[]){
	   Labels l = new Labels(); 
//	   l.breakLabel();
	   l.label006();
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
//		       if (c > 3) break JILL; else c++;//DOES NOT COMPILE
	   }
	}		

	public void label002() {
	   int c = 0;
	   JILL: System.out.println(c);
	   JACK: while (c < 8){
//		   if (c > 3) break JILL; else c++;//DOES NOT COMPILE
	   }
	}		

	public void label003() {
	   int c = 0;
	   JILL: while(c > 3) {
		   JACK: while (c < 8){
			   if (c > 3) 
				   break JILL;//OK
			   else c++;
		   }
	   }
	}		

	public void label004() {
	   int c = 0;
	   JILL: if(c == 0) {
		   JACK: while (c < 8){
			   if (c > 3) 
				   break JILL;//OK
			   else c++;
		   }
	   }
	   System.out.println(c);
	}		

	public void label005() {
	   int c = 0;
	   JILL: {
		   JACK: while (c < 8){
			   if (c > 3) 
				   break JILL;//OK
			   else c++;
		   }
	   }
	   System.out.println(c);
	}		

	public void label006() {
	   int c = 0;
	   FORLOOP: for(c = 4;c<=5;c++) {
		   FRANK:{
			   JILL: {
				   JACK: if(c < 8){
					   if (c > 3) //3 < c < 8
						   break JILL;//OK
					   else if (c > 4)//c <= 3 
						   break FRANK;//OK
					   else
						   break FORLOOP;
				   }
				   System.out.println("inside JILL");
			   }
			   System.out.println("inside FRANK");
		   }
		   System.out.println("for loop");
	   }
	   System.out.println("outside for loop");
	   System.out.println(c);
	}		
}
