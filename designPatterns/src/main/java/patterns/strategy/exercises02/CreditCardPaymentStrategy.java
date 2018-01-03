package patterns.strategy.exercises02;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("pay by credit card");
    }
}

