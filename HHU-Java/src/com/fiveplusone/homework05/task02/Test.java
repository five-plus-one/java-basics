package com.fiveplusone.homework05.task02;

public class Test {
    public static void main(String[] args) {
        SmartDevice[] smartDevices = new SmartDevice[]{
                new SmartBulb(),
                new SmartAC(),
                new SmartCurtain()
        };
        SmartHomeHub.leaveHome(smartDevices);
    }
}
