package com.fiveplusone.homework04.task05;

public class Test {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new CreditCardPayment();
        paymentGateway.processPayment(199.9);
        paymentGateway = new CryptoPayment();
        paymentGateway.processPayment(500.0);
    }
}
