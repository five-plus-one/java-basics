package com.fiveplusone.arraydemo;

import java.util.Random;

public class ArrayTest4 {
    static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        // 索引范围 : 0 1 2 3 4
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
