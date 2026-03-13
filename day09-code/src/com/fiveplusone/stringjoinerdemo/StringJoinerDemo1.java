package com.fiveplusone.stringjoinerdemo;

import java.util.StringJoiner;

public class StringJoinerDemo1 {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",","[","]");
        sj.add("a").add("b").add("c");
        System.out.println(sj);

        String str = new StringJoiner(",","[","]").add("aaa").add("bbb").add("ccc").toString();
        System.out.println(str);
    }
}
