package com.fiveplusone.test;

public class Test1 {
    static void main(String[] args) {
        getLength(5.2,1.3);
    }
    public static void getLength(double len,double width){
        double result = (len + width) * 2;
        System.out.println(result);
    }
}
