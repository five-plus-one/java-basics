package com.fiveplusone.arraydemo;

public class ArrayDemo1 {
    public static void main(String[] args) {
        //格式
        //静态初始化
        //数据类型 [] 数组名 = new 数据类型[]{元素1,元素2...};
        //简化格式:
        //数据类型 [] 数组名 = {元素1,...};
        int[] arr1 = new int[]{11,12,13,14};
        int[] arr2 = {11,12,13,14};

        String[] arr3 = new String[]{"ZhangSan","LiSi","WangWu"};
        String[] arr4 = {"ZhangSan","LiSi","WangWu"};

        double[] arr5 = new double[]{1.93,1.75,1.73,1.81};
        double[] arr6 = {1.93,1.75,1.73,1.81};

        System.out.println(arr6); //[D@f6f4d33 ,地址值
    }
}
