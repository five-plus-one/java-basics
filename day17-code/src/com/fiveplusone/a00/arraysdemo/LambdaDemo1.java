package com.fiveplusone.a00.arraysdemo;

public class LambdaDemo1 {
    public static void main(String[] args) {
        method(new Swim() {
            @Override
            public void swimming() {
                System.out.println("正在游泳");
            }
        });

        method(()->{
            System.out.println("正在游泳...");
        });

    }
    public static void method(Swim s){
        s.swimming();
    }
}

@FunctionalInterface
interface Swim{
    public abstract void swimming();
}