package org.example.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal Account: ");
        // Logic for PayPal payment processing would go here
    }
}