package com.fiveplusone.homework01;

public class GetGCD {
    static void main(String[] args) {
        System.out.println(getGCD(12,18));
    }

    /*
     * 求最大公约数
     * @param a 第一个整数
     * @param b 第二个整数
     * @return 最大公约数
     */
     static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
