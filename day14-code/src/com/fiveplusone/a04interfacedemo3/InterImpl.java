package com.fiveplusone.a04interfacedemo3;

public class InterImpl implements inter{
    @Override
    public void method() {
        System.out.println("实现类重写的抽象方法");
    }

    @Override
    public void show() {
        System.out.println("实现类重写的默认方法 --- show");
    }
}
