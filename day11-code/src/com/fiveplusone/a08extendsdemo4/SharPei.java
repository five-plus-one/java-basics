package com.fiveplusone.a08extendsdemo4;

public class SharPei extends Dog{
    @Override
    public void eat() {
        super.eat(); //吃狗粮
        System.out.println("狗啃骨头");
    }
}
