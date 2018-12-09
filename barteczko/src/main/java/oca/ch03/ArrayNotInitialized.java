package oca.ch03;

public class ArrayNotInitialized {
	
	//Uważać na niezainicjalizowane tablice
	public static void main(String[] args) {
		String[] stringArray = new String[2];//Tablica inicjalizowana null
		for(String s : stringArray) {
			System.out.println(s.concat("a"));//Throws NullPointerException
		}
	}

}
