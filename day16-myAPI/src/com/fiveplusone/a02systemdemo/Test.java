package com.fiveplusone.a02systemdemo;

public class Test {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = new int[10];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
