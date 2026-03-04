package com.fiveplusone.test;

public class Test7 {
    static void main(String[] args) {
        int[] arr = {1, 5, 8, 12, 56, 89, 34, 67};
        boolean flag = contains(arr,89);
        System.out.println(flag);
    }
    public static boolean contains(int[] arr,int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
}
