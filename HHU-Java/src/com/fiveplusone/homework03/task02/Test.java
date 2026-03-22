package com.fiveplusone.homework03.task02;

public class Test {
    public static void main(String[] args) {
        // 生成随机安全码
        System.out.println("本次生成的随机安全码为：" + SecurityUtils.generateCode());

        // 校验密码是否符合要求
        System.out.println("密码“123456”的校验结果为：" + SecurityUtils.isValidPassword("123456"));
        System.out.println("密码“admin12345”的校验结果为：" + SecurityUtils.isValidPassword("admin12345"));
    }
}
