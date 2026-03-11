package com.fiveplusone.test3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //键盘录入：
        //第一套体系
        //nextInt();接受整数
        //nextDouble();接受小数
        //next();接受字符串
        //遇到空格，制表符，回车就停止接受，这些符号后面数据就不会接受了。

        //第二套体系
        //nextLine();接受字符串
        //可以接受空格，制表符，遇到回车才停止接受
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串");
        String line1 = sc.nextLine();
        System.out.println(line1);
        System.out.println("请输入第二个字符串");
        String line2 = sc.nextLine();
        System.out.println(line2);
    }
}
