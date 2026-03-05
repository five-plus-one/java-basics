package com.fiveplusone.test;

public class PhoneTest {
    static void main(String[] args) {
        Phone p = new Phone();
        p.brand = "小米";
        p.price = 1999.98;

        System.out.println(p.brand);
        System.out.println(p.price);

        p.call();
        p.playGame();
    }
}
