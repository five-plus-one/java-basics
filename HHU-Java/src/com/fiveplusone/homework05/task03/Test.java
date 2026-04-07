package com.fiveplusone.homework05.task03;

public class Test {
    public static void main(String[] args) {
        Knight knight = new Knight();
        Gargoyle gargoyle = new Gargoyle();
        PegasusRider pegasusRider = new PegasusRider();
        AntiAirTower antiAirTower = new AntiAirTower();
        antiAirTower.lockAndFire(gargoyle);
        antiAirTower.lockAndFire(pegasusRider);
        //antiAirTower.lockAndFire(knight);   报错：java: 不兼容的类型: com.fiveplusone.homework05.task03.Knight无法转换为com.fiveplusone.homework05.task03.Flyable

    }
}
