package com.fiveplusone.test;

import java.util.Scanner;

public class LoopTest2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) {
            if(i * i == number) {
                System.out.println(i);
                break;
            }else if(i * i > number) {
                System.out.println(i-1);
                break;
            }
        }
    }
}
