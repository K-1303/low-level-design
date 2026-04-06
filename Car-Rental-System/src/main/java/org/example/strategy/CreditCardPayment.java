package org.example.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card details: " + ", "
                 + ", expires: " );
        // Logic for credit card payment processing would go here
    }
}
