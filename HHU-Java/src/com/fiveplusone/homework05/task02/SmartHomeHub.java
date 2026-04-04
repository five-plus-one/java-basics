package com.fiveplusone.homework05.task02;

public class SmartHomeHub {
    private SmartHomeHub() {}
    public static void leaveHome(SmartDevice[] devices){
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOff();
        }
    }
}
