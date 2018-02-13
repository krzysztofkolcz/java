package ch02.sub05;

public class Journal extends Publication{

    public static String getInfo(){
        return "Journal info";
    }

    @Override
    public Person getAuthor() {
        return null;
    }
}
