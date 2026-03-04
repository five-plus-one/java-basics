package com.fiveplusone.test;

public class Test6 {
    static void main(String[] args) {
        int[] arr = {1, 5, 7, 3, 8, 10};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
