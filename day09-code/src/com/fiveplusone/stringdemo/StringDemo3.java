package com.fiveplusone.stringdemo;

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str1 = sc.next(); //abc 是new出来的
        String str2 = "abc";
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2));

        //结论：
        //以后只要想比较字符串的内如果您，就必须用String里面的方法
    }
}
