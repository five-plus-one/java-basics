package com.fiveplusone.stringbuilderdemo;

import java.util.Scanner;

public class StringBuilderDemo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();

        String result  = new StringBuilder().append(str).reverse().toString();

        if(str.equals(result)){
            System.out.println("该字符串是回文字符串");
        }else{
            System.out.println("该字符串不是回文字符串");
        }
    }
}
