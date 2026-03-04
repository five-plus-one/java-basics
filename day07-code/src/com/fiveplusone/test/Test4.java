package com.fiveplusone.test;

public class Test4 {
    static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }
}
