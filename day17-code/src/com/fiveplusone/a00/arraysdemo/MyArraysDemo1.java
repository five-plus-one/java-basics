package com.fiveplusone.a00.arraysdemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MyArraysDemo1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,9));

        int[] arr2 = Arrays.copyOfRange(arr,0,3);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {10,0,1,5,3,9,2,8};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        Integer[] arr4 = {2,3,1,5,6,7,8,4,9};

        //o1-o2升序，o2-o1降序
        Arrays.sort(arr4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr4));
    }
}
