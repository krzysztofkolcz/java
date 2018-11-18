package oca.ch05.inheritance.accesstomembers;


public class Shark extends Fish{
    public Shark(int age) {
		super(age);
	}
	private int numberOfFins = 8;
    public void method(){

            //dostęp do zmiennej protected int size
			System.out.println(this.size);
			System.out.println(super.size);
			System.out.println(size);

            //brak dostępu do zmiennej private int age w klasie dziecka

            //dostęp do metody public int gt:
			System.out.println(this.getAge());
			System.out.println(super.getAge());
			System.out.println(getAge());

			System.out.println(numberOfFins);
			System.out.println(this.numberOfFins);
            //nie można użyć super do zmiennej nie bedaca zmienna z parenta.

			System.out.println(this.speed);
			System.out.println(super.speed);
    }
    
    public static void main(String[] args) {
		Shark s = new Shark(17);
		s.method();
	}

}
