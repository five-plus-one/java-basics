package com.fiveplusone.listdemo;

import java.util.ArrayList;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");


        boolean result = list.remove("aaa");
        System.out.println(result);
        System.out.println(list);

        String str = list.remove(0);
        System.out.println(str);
        System.out.println(list);

        str = list.set(1,"ddd");
        System.out.println(str);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}
