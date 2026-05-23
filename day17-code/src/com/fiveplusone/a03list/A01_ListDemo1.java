package com.fiveplusone.a03list;

import java.util.ArrayList;
import java.util.List;

public class A01_ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        list.add(1,"qqq");

        System.out.println(list);
        String remove = list.remove(0);

        System.out.println(list);
    }
}
