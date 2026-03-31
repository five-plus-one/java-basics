package com.fiveplusone.homework04.task02;

public class Test {
    public static void main(String[] args) {
        // 创建数组
        SmartDevice[] smartDevices = new SmartDevice[4];
        // 批量创建智能设备
        for (int i = 0; i < smartDevices.length; i++) {
            if(i%2 == 0){
                smartDevices[i] = new SmartLight();
            }else{
                smartDevices[i] = new SmartThermostat();
            }
        }
        // 利用多态激活节能模式
        for (int i = 0; i < smartDevices.length; i++) {
            smartDevices[i].activateEcoMode();
        }
    }
}
