package com.fiveplusone.homework05.task05.com.pay.core;

public class PaymentGateway {
    public void process(PaymentMethod method,double amount){
        SecurityCheck check = new SecurityCheck();
        check.doCheck();
        method.pay(amount);
    }
}
