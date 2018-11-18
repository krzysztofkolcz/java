package oca.ch05.inheritance.access;

interface Flyer{ 
	String getName(); 
}  

class Bird implements Flyer{     
	public String name;
	public Bird(String name){         
		this.name = name;
	}     

	public String getName(){ 
		return name;
	} 
}  

class Eagle extends Bird {     
	public Eagle(String name){         
		super(name);     
	} 
}  

public class TestClass {     
	public static void main(String[] args) throws Exception {         
		Flyer f = new Eagle("American Bald Eagle");         

		System.out.println(f.getName());//OK
		System.out.println(((Bird)f).getName());//OK
		System.out.println(((Eagle)f).getName());//OK

//		System.out.println(f.name);//DOES NOT COMPILE
		System.out.println(((Bird)f).name);//OK
		System.out.println(((Eagle)f).name);//OK
	} 
}