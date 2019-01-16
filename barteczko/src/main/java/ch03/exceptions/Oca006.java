package ch03.exceptions;

public class Oca006 {
	public String name;

	public void parseName() {
		System.out.print("1");
		try {
			System.out.print("2");
			int x = Integer.parseInt(name);
			System.out.print("3");
		} catch (NullPointerException e) {
			System.out.print("4");
		}
		System.out.print("5");
	}

	public static void main(String[] args) {
		Oca006 leo = new Oca006();
		leo.name = "Leo";
		leo.parseName();
		System.out.print("6");
	}
}