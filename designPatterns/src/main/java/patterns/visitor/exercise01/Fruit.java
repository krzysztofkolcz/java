package patterns.visitor.exercise01;

public class Fruit implements Item{

    private int price;
    private int weight;

    public Fruit(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitFruit(this);
    }
}
