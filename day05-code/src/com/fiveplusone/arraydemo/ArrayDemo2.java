package com.fiveplusone.arraydemo;

public class ArrayDemo2 {
    static void main(String[] args) {
        //利用索引对数组中的元素进行访问
        //1.获取数组中的元素
        //  格式：数组名[索引]

        int[] arr = {1,2,3,4,5};
        int number = arr[0];
        System.out.println(number);
        System.out.println(arr[1]);
        //2.把数据存储到数组当中
        //  格式： 数组名[索引] = 具体数据 / 边拉你个
        //  细节：一旦覆盖，原来的数据就不存在了
        arr[0] = 100;
        System.out.println(arr[0]);
    }
}
