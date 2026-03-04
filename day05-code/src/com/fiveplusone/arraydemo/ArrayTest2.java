package com.fiveplusone.arraydemo;

import java.util.Random;

public class ArrayTest2 {
    static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int number = r.nextInt(100) + 1;
            arr[i] = number;
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组元素的和为："+sum);

        double avg = sum * 1.0 / arr.length;
        System.out.println("数组元素的平均值为："+avg);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<avg){
                count++;
            }
        }
        System.out.println("数组中小于平均值的元素个数为："+count);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
