package com.fiveplusone.homework04.task05;

//子类：信用卡支付
public class CreditCardPayment extends PaymentGateway {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing CREDIT payment: $" + amount);
        System.out.println("信用卡实际扣款完毕。");
    }
}
