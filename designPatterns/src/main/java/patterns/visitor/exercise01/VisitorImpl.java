package patterns.visitor.exercise01;

public class VisitorImpl implements Visitor{
    @Override
    public int visitBook(Book b) {
        return b.getPrice();
    }

    @Override
    public int visitFruit(Fruit f) {
        return f.getPrice()*f.getWeight();
    }
}
