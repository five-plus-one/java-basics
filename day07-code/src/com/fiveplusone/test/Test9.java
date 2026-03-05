package com.fiveplusone.test;

import java.util.Random;

public class Test9 {
    static void main(String[] args) {
        //1.定义数组，表示奖池
        int[] arr = {2, 588, 888, 1000, 10000};
        //2.定义新数组，用于存储抽奖的结果
        int[] newArr = new int[arr.length];
        //3.抽奖
        //因为有5个奖项，所以循环5次
        Random r = new Random();
        for (int i = 0; i < 5; ) {
            int randomIndex = r.nextInt(arr.length);
            int prize = arr[randomIndex];
            if(!contains(newArr, prize)){
                //把当前抽到的奖项添加到newArr中
                newArr[i] = prize;
                i++;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

    }

    public static boolean contains(int[] arr, int prize){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == prize){
                return true;
            }
        }
        return false;
    }
}
