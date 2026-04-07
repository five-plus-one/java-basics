package com.fiveplusone.homework05.task05.com.pay.channel;

import com.fiveplusone.homework05.task05.com.pay.core.PaymentMethod;

public class WeChatPay implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("使用微信支付支付" + amount + "元");
    }
}
