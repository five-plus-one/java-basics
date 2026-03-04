package com.fiveplusone.methoddemo;

import java.util.Scanner;

public class MethodDemo3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个整数：");
        int num2 = sc.nextInt();
        getSum(num1,num2);
    }

    public static void getSum(int num1,int num2){
        int result = num1 + num2;
        System.out.println(result);
    }
}
