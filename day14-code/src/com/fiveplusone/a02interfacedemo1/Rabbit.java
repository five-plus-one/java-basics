package com.fiveplusone.a02interfacedemo1;

public class Rabbit extends Animal{

    @Override
    public void eat() {
        System.out.println("兔子在吃胡萝卜");
    }

    public Rabbit() {
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }


}
