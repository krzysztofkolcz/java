package patterns.strategy.exercises02;

public class PayPalPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("pay by paypal");
    }
}
