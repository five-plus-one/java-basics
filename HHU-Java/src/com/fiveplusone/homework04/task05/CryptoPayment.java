package com.fiveplusone.homework04.task05;

public class CryptoPayment extends PaymentGateway {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing CRYPTO payment: equivalent of $" + amount + " BTC");
        System.out.println("加密货币实际扣款完毕。");
    }
}
