package com.fiveplusone.homework05.task02;

public class SmartCurtain implements SmartDevice{
    @Override
    public void turnOn() {
        System.out.println("窗帘缓缓打开");
    }

    @Override
    public void turnOff() {
        System.out.println("窗帘缓缓关闭");
    }
}
