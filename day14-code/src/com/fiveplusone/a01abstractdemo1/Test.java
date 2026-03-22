package com.fiveplusone.a01abstractdemo1;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("Zhangsan",23);
        System.out.println(s.getName() + ", " + s.getAge());
        s.work();
    }
}
