package oca.ch04.pond.shore;

public class BirdChild extends Bird{

	public void watchBird() {
		Bird bird = new Bird();
		bird.floatInWater(); // calling protected member
		System.out.println(bird.text); // calling protected member
	} 
	
	public void watchSelf() {
		floatInWater();
		System.out.println(text); 
	}
}
