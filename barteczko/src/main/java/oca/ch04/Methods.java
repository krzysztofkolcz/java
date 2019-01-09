package oca.ch04;

import java.util.ArrayList;
import java.util.List;

public class Methods {
	
	/*
	public void method1() throws Exception001{
		return ;
	}

	public void method1() throws Exception002{//DOES NOT COMPILE
		return ;
	}
	*/

//	public void method1(List<Integer> list) {}//DOES NOT COMPILE
//	public void method1(List<String> list) {}
	
	public static void main(String[] args) {
		Methods m = new Methods();
		List<String> s = m.m();
		System.out.println(s);
	}
	public List<String> m(){
		List<String> s = new ArrayList<String>();
		System.out.println(s);
		return s;
		
	}
}
