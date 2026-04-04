package com.fiveplusone.homework05.task02;

public class SmartBulb implements SmartDevice{
    @Override
    public void turnOn() {
        System.out.println("灯泡亮起白光");
    }

    @Override
    public void turnOff() {
        System.out.println("灯泡缓缓熄灭");
    }
}
