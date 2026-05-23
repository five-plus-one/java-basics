package com.fiveplusone.a02collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

public class A01_CollectionDemo1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("a");
        coll.add("b");
        System.out.println(coll);
        coll.clear();
        System.out.println(coll);
        coll.add("c");
        coll.add("c");
        coll.add("a");
        coll.remove("c");
        System.out.println(coll);
        boolean res = coll.contains("c");
        System.out.println(res);
    }
}
