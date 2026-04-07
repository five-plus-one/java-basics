package com.fiveplusone.homework05.task05.com.pay.test;

import com.fiveplusone.homework05.task05.com.pay.channel.WeChatPay;
import com.fiveplusone.homework05.task05.com.pay.core.PaymentGateway;

//import com.fiveplusone.homework05.task05.com.pay.core.SecurityCheck;
//报错：'com.fiveplusone.homework05.task05.com.pay.core.SecurityCheck' 在 'com.fiveplusone.homework05.task05.com.pay.core' 中不为 public。无法从外部软件包访问

public class Main {
    public static void main(String[] args) {
        WeChatPay weChatPay = new WeChatPay();
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.process(weChatPay,199.9);
//        SecurityCheck check = new SecurityCheck();
        //报错：'com.fiveplusone.homework05.task05.com.pay.core.SecurityCheck' 在 'com.fiveplusone.homework05.task05.com.pay.core' 中不为 public。无法从外部软件包访问
        /*
         * * 【编译器报错原因解释】：
         * SecurityCheck 类在定义时，省略了 public 修饰符。
         * 在 Java 中，不写修饰符代表“默认访问权限”。
         * 这意味着 SecurityCheck 类对于 com.pay.core 包外的任何代码都是“不可见”的。
         * 我们的 Main 类在 com.pay.test 包下，跨包访问时，编译器会进行权限拦截并报错
         * * 这正是面向对象中“封装”的最高级体现：核心引擎把自己的敏感组件藏在了包内部，
         * 只对外暴露一个安全的门面（PaymentGateway），从而保证了系统的绝对安全！
         */
    }
}
