package com.fiveplusone.a00.arraysdemo;

import java.util.Arrays;
import java.util.Comparator;

public class MyArraysDemo2 {
    public static void main(String[] args) {
        Integer[] arr4 = {2,3,1,5,6,7,8,4,9};

        //o1-o2升序，o2-o1降序
//        Arrays.sort(arr4, (Integer o1, Integer o2)->{
//                return o2 - o1;
//            }
//        );
        Arrays.sort(arr4,(o1,o2)->o2-o1);
        System.out.println(Arrays.toString(arr4));
    }
}
