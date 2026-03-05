package com.fiveplusone.test;

public class Test7 {
    static void main(String[] args) {
        //1.计算出数组的长度
        int number = 12345;
        //定义一个变量，临时记录number的值
        int temp = number;
        //定义一个变量进行统计
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++; //每次循环，去掉右边的第一个数字
        }
        //2.定义数组
        //动态初始化
        int[] arr = new int[count];
        //3.把证书上的每一位都加到数组中
        int index = arr.length - 1;
        while (temp != 0) {
            int ge = temp % 10;
            temp /= 10;
            arr[index] = ge;
            index--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
