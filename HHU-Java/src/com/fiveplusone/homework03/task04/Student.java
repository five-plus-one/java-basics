package com.fiveplusone.homework03.task04;

public class Student {
    // 实例变量
    private String name;
    private int wallet;

    //静态变量
    private static int classFund = 0;

    //构造方法：传入姓名，将初始钱包设为100
    public Student(String name) {
        this.name = name;
        this.wallet = 100;
    }

    //实例方法：缴纳班费
    public void payFund(int amount) {
        if (this.wallet >= amount) {
            this.wallet -= amount;
            classFund += amount;
            System.out.println(this.name + " 成功缴纳班费 " + amount + " 元。");
        } else {
            System.out.println(this.name + " 缴纳失败，余额不足！");
        }
    }

    //实例方法：打印当前学生余额
    public void showWallet() {
        System.out.println(this.name + " 的钱包余额：" + this.wallet);
    }

    //静态方法：打印总班费
    public static void showClassFund() {
        System.out.println("当前班级活动基金总计：" + classFund + " 元");
    }
}
