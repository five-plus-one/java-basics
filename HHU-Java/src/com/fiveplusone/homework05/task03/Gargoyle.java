package com.fiveplusone.homework05.task03;

public class Gargoyle extends Monster implements Flyable{
    @Override
    public void fly() {
        System.out.println("石像鬼在飞！");
    }

    @Override
    public void attack() {
        System.out.println("石像鬼发起攻击！");
    }
}
