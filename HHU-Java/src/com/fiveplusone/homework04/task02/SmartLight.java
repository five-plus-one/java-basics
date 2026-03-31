package com.fiveplusone.homework04.task02;

//子类 智能灯泡
public class SmartLight extends SmartDevice{
    @Override
    public void activateEcoMode() {
        System.out.println("Light brightness reduced to 50%");
    }
}
