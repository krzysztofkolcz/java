package ch02.sub05;

public class Book extends Publication{

    public static String getInfo(){
        return "Book info";
    }

    @Override
    public Author getAuthor() {
        return null;
    }
}
