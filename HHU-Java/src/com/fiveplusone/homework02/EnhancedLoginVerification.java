package com.fiveplusone.homework02;

import java.util.Scanner;

public class EnhancedLoginVerification {
    public static void main(String[] args) {
        // 预设常量
        String ADMIN_USER = "HohaiStudent";
        String ADMIN_PASS = "HHU2026";

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String user = sc.next();
        System.out.print("请输入密码: ");
        String pass = sc.next();

        // 用户名忽略大小写，密码必须精确一致
        if (ADMIN_USER.equalsIgnoreCase(user) && ADMIN_PASS.equals(pass)) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误。");
        }
    }
}
