package com.fiveplusone.a02.staticdemo2;

public class TestDemo {
    public static void main(String[] args) {
        //测试工具类中的两个方法是否正确
        int[] arr1 = {1,2,3,4,5};
        String str = ArrayUtil.printArr(arr1);
        System.out.println(str);

        double[] arr2 = {1.0,2.0,3.0,4.0,5.0};
        double average = ArrayUtil.getAverage(arr2);
        System.out.println(average);
    }
}
