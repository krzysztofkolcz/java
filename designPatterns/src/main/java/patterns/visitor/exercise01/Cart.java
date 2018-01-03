package patterns.visitor.exercise01;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    Set<Item> itemSet;

    public Cart() {
        this.itemSet = new HashSet<>();
    }

    public void addItem(Item i){
        itemSet.add(i);
    }

    public void calculate(){
        Visitor v = new VisitorImpl();
        int sum = itemSet.stream().map(e -> e.accept(v)).reduce(0,(e1,e2) -> e1 + e2);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Book(100));
        cart.addItem(new Fruit(100,12));
        cart.calculate();
    }
}
