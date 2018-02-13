package ch02.sub05;

public class InheritanceTest {
    public static void main(String[] args) {
        Book book = new Book();
        Journal journal = new Journal();
        System.out.println(Book.getInfo());
        System.out.println(Journal.getInfo());
    }
}
