package com.fiveplusone.a02collectiondemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class A02_CollectionDemo2 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");

        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {

        }
    }
}
