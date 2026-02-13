package com.fiveplusone.arithmeticoperator;

public class ArithmeticoperatorDemo2 {
    //结论:
    //1. 整数参与计算，结果只能是整数
    //2. 小数参与计算，结果可能不精确
    static void main(String[] args) {
        //除法
        System.out.println(10/2); //5
        System.out.println(10/3); //3
        System.out.println(10.0/3); //3.3333333333333335

        //取模，取余，实际上也是除法运算，只不过得到的是余数
        System.out.println(10 % 2); //0
        System.out.println(10 % 3); //1
    }
}
