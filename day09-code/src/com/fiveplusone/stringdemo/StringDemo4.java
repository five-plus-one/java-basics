package com.fiveplusone.stringdemo;

import java.util.Scanner;

public class StringDemo4 {
    public static void main(String[] args) {
        String rightUsername = "Zhangsan";
        String rightPassword = "123456";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();

            if (username.equals(rightUsername) && password.equals(rightPassword)) {
                System.out.println("登录成功！");
                break;
            } else {
                if(i == 2){
                    System.out.println("账号" + username + "被锁定！");
                }else{
                    System.out.println("用户名或密码错误，您还剩下"+(2-i)+"次机会");
                }
            }
        }
    }
}
