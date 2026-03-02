package com.fiveplusone.test;

import java.util.Scanner;

public class LoopTest6 {
    public static void main(String[] args) {
        //需求：输入一个大于2的整数，输出其平方根，结果只保留整数部分
        //1.键入一个整数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int number = sc.nextInt();
        //2.从1开始循环判断
        for (int i = 1; i <= number; i++) {
            if(i * i == number){
                System.out.println(i + "就是" + number + "的平方根");
                break;
            } else if (i * i > number) {
                System.out.println((i-1) + "是" + number + "的平方根的整数部分");
                break;
            }
        }
    }
}
