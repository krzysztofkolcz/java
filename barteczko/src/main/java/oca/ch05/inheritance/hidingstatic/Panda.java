package oca.ch05.inheritance.hidingstatic;

class Bear {
        public static void eat() {
                System.out.println("Bear");
        }
        public static void onlyinparent() {
                System.out.println("only in parent");
        }
}

public class Panda extends Bear {
	 public static void eat() { // static tak jak w parent - metoda ukrywa metodę parenta.
			 System.out.println("Panda");
	 }
	 public static void main(String[] args) {
		 Bear.eat();//Bear
		 Panda.eat();//Panda

		 Bear b = new Bear();
		 b.eat();//Bear
		 Panda p = new Panda();
		 p.eat();//Panda
		 
		 Bear pb = new Panda();
		 pb.eat();//Bear
		 ((Panda)pb).eat();//Panda
		 
		 Panda.onlyinparent();
		 
	 }
}
