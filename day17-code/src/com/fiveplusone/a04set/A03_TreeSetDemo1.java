package com.fiveplusone.a04set;

import java.util.Iterator;
import java.util.TreeSet;

public class A03_TreeSetDemo1 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(4);
        ts.add(5);
        ts.add(1);
        ts.add(2);
        ts.add(3);

        System.out.println(ts);

        Iterator<Integer> it = ts.iterator();
        while(it.hasNext()){
            int i = it.next();
            System.out.println(i);
        }

        for (Integer t : ts) {
            System.out.println(t);
        }


        ts.forEach(i-> System.out.println(i));
    }
}
