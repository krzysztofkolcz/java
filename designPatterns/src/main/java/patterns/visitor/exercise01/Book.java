package patterns.visitor.exercise01;

public class Book implements Item{

    private int price;

    public Book(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitBook(this);
    }
}
