package oca.ch04.pond.priv;

public class KlasaObokQ {

	public void metoda002() {
//		method();//brak dostępu do metody package-private jeżeli klasa nie dziedziczy.
		new KlasaRodzic().method();//ten dostęp jest ok
	}
	
	public static void main(String[] args) {
		new KlasaObokQ().metoda002();
	}

}
