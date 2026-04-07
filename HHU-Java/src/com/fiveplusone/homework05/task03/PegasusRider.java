package com.fiveplusone.homework05.task03;

public class PegasusRider extends Hero implements Flyable{
    @Override
    public void fly() {
        System.out.println("飞马骑士在飞！");
    }

    @Override
    public void attack() {
        System.out.println("飞马骑士发起进攻！");
    }
}
