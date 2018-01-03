package patterns.strategy.exercises02;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();
        PayPalPaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy();
        CreditCardPaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy();

        cart.pay(payPalPaymentStrategy);
        cart.pay(creditCardPaymentStrategy);


    }
}
