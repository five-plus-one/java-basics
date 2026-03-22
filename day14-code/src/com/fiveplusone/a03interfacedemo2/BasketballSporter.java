package com.fiveplusone.a03interfacedemo2;

public class BasketballSporter extends Sporter{
    public BasketballSporter() {
    }

    public BasketballSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("蓝球运动员打篮球");
    }

}
