package com.fiveplusone.arithmeticoperator;

public class ArithmeticoperatorDemo1 {
    static void main(String[] args) {
        //+
        System.out.println(3+2); //5
        //-
        System.out.println(5-1); //4
        //*
        System.out.println(3*2); //6

        //如果计算的时候有小数参与
        //结论：
        //在代码中，如果有小数参与计算，结果可能不精确
        System.out.println(1.1 + 1.1); //2.2
        System.out.println(1.1 + 1.01); //2.1100000000000003
        System.out.println(1.1 - 1.01); //0.09000000000000008
        System.out.println(1.1 * 1.01); //1.1110000000000002
    }
}
