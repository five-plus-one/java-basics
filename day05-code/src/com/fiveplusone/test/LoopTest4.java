package com.fiveplusone.test;


import java.util.Random;

public class LoopTest4 {
    static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(100); // 0 - 99
        System.out.println("随机数为：" + number);

    }
}

