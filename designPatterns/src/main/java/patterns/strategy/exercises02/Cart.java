package patterns.strategy.exercises02;

public class Cart {

    public void pay(PaymentStrategy paymentStrategy){
       paymentStrategy.pay();
    }
}
