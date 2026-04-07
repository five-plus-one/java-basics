package com.fiveplusone.homework05.task03;

public class AntiAirTower {
    public void lockAndFire(Flyable target){
        target.fly();
        System.out.println("导弹击落目标！");
    }
}
