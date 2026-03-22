package com.fiveplusone.homework03.task04;

public class Test {
    public static void main(String[] args) {
        //添加学生
        Student s1 = new Student("周云杰");
        Student s2 = new Student("林晓月");
        Student s3 = new Student("顾川");
        //缴纳班费
        s1.payFund(50);
        s2.payFund(20);
        s3.payFund(150);
        System.out.println("====================");
        //打印学生余额
        s1.showWallet();
        s2.showWallet();
        s3.showWallet();
        //打印总班费
        Student.showClassFund();
    }
}
