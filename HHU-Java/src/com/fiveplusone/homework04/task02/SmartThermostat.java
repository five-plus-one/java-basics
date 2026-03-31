package com.fiveplusone.homework04.task02;

//子类，智能温控器
public class SmartThermostat extends SmartDevice{
    @Override
    public void activateEcoMode() {
        System.out.println("Temperature set to 20°C (Eco Mode)");
    }
}
