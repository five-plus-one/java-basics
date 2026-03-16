package com.fiveplusone.a05extendsdemo1;

public class Test {
    public static void main(String[] args) {
        //创建对象并调用方法

        Ragdoll rd =  new Ragdoll();
        rd.eat();
        rd.drink();
        rd.catchMouse();

        Husky h = new Husky();
        h.eat();
        h.drink();
        h.breakHome();
    }
}
