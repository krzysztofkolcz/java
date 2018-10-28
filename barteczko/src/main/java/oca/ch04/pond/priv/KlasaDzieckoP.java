package oca.ch04.pond.priv;

public class KlasaDzieckoP extends KlasaRodzic{

	public void metoda002() {
		method();//dostęp do metody package-private rodzica.
		new KlasaRodzic().method();//ten dostęp jest ok
	}
	
	public static void main(String[] args) {
		new KlasaDzieckoP().metoda002();
	}
}
