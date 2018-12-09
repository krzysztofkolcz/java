package oca.ch03;

public class ArrayNull {

    public static int[ ] getArray() {  
    	return null; 
	}    

    public static void main(String[] args){       
    	int index = 1;       
    	try{          
    		getArray()[index=2]++;       
		}catch (Exception e){  
			System.out.println(e);//NullPointerException
		}
    	System.out.println("index = " + index);
    	
    	int[] array = null;
    	try {
			System.out.println(array[0]);
    	}catch(Exception e) {
			System.out.println(e);//NullPointerException
    	}
    }
}