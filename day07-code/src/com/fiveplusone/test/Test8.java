package com.fiveplusone.test;

public class Test8 {
    static void main(String[] args) {
        int[] arr = {8, 3, 4, 6};
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 由于加密是通过对 10 取余的方式进行获取的，所以在解密的时候就需要判断
        // 0-4之间+10,5-9之间不变
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0 && arr[i] <= 4){
                arr[i] = arr[i] + 10;
            }
        }
        //解密的时候每一位减5即可
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 5;
        }
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number = number * 10 +arr[i];
        }
        System.out.println(number);
    }
}
