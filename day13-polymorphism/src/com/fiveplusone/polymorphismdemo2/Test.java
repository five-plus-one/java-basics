package com.fiveplusone.polymorphismdemo2;

public class Test {
    public static void main(String[] args) {
        //调用成员变量：编译看左边，运行也看左边
        //编译看左边：javac编译代码时，会看左边的父类中有没有这个变量，如果有，编译成功，否则失败
        //运行也看左边：java运行代码时，实际获取的是左边父类中的成员变量的值
        Animal a = new Dog();
        System.out.println(a.name);

        //调用成员方法：编译看左边，运行看右边
        //编译看左边：javac编译代码时，会看左边父类中有没有这个方法，如果有，编译成功，否则失败
        //运行看右边：java运行代码时，实际调用的是右边子类中的方法
        a.show();
    }
}


class Animal {
    String name = "动物";

    public void show(){
        System.out.println("Animal - show");
    }
}

class Dog extends Animal {
    String name = "狗";
    public void show(){
        System.out.println("Dog - show");
    }
}