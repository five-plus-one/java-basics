package com.fiveplusone.test;

public class Test2 {
    static void main(String[] args) {
        getArea(5.2);
    }
    public static void getArea(double radius){
        double result = Math.PI * radius * radius;
        System.out.println(result);
    }
}
