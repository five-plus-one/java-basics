package com.fiveplusone.a04interfacedemo3;

public interface inter {
    public abstract void method();
    public default void show(){
        System.out.println("接口中的默认方法 --- show");
    }
}
