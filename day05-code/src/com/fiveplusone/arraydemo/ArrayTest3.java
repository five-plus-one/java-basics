package com.fiveplusone.arraydemo;

public class ArrayTest3 {
    static void main(String[] args) {
        //  1.定义数组存储数据
        int[] arr = {1,2,3,4,5};
        //  2.利用循环交换数据
        for(int i = 0, j = arr.length-1; i<j; i++,j--){
            // 交换变量 i 和变量 j 指向的元素
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        //当循环结束之后，数组中的数据就实现了交换
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
