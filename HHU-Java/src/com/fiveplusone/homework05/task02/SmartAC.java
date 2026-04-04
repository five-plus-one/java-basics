package com.fiveplusone.homework05.task02;

public class SmartAC implements SmartDevice{
    @Override
    public void turnOn() {
        System.out.println("空调开始制冷");
    }

    @Override
    public void turnOff() {
        System.out.println("空调停止制冷");
    }
}
