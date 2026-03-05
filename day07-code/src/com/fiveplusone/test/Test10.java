package com.fiveplusone.test;

import java.util.Random;

public class Test10 {
    static void main(String[] args) {
        int[] arr = {2, 588, 888, 1000, 10000};
        //1. 把奖池里面的所有奖项打乱顺序
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            //获取随机索引
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        //2.遍历奖池
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
