package com.fiveplusone.stringbuilderdemo;

public class StringBuilderDemo2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("test");
        sb.append(1);
        sb.append(2.3);
        sb.append(true);
        sb.reverse();
        int len = sb.length();
        System.out.println(len);
        //因为StringBuilder是Java已经写好的类
        //java在底层做了一些特殊处理，打印对象不是地址值而是属性值
        System.out.println(sb);
    }
}
