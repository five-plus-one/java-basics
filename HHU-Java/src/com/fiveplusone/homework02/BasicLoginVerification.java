package com.fiveplusone.homework02;

import java.util.Scanner;

public class BasicLoginVerification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        if(username.equals("root") && password.equals("123456")){ // 使用 && 确保两个条件同时成立
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }
}
