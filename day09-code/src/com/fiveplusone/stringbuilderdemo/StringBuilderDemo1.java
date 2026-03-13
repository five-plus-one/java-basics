package com.fiveplusone.stringbuilderdemo;

public class StringBuilderDemo1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100000; i++) {
            sb.append("abc");
        }
        System.out.println(sb);
    }
}
