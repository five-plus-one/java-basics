package com.fiveplusone.arraydemo;

public class ArrayDemo5 {
    static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        //长度5，索引0-4
        //System.out.println(arr[10]);  //会造成索引越界异常
        //原因：访问了不存在的索引
        //避免：索引不要超出范围
        System.out.println(arr[4]);
    }
}
