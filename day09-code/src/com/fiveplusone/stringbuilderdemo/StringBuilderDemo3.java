package com.fiveplusone.stringbuilderdemo;

public class StringBuilderDemo3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("aaa");
        sb.append("bbb");
        sb.append("ccc");
        sb.append("ddd");

        sb.append("eee").append("fff").append("ggg").append("hhh");
        String str = sb.toString();
        System.out.println(str);

    }
}
