package com.fiveplusone.methoddemo;

public class MethodDemo4 {
    static void main(String[] args) {
        //直接调用
        //getSum(10,20,30);
        //赋值调用
        //int sum = getSum(10,20,30);
        //输出调用
        //System.out.println(getSum(10,20,30));
        int sum1 = getSum(10,20,30);
        int sum2 = getSum(20,30,40);
        int sum3 = getSum(30,40,50);
        int sum4 = getSum(40,50,60);
        //求全年总营业额
        int total = sum1 + sum2 + sum3 + sum4;
        System.out.println("全年总营业额为：" + total);
    }
    public static int getSum(int num1,int num2,int num3){
        int result = num1 + num2 + num3;
        return result;
    }
}
