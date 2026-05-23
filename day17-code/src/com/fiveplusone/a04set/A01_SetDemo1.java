package com.fiveplusone.a04set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class A01_SetDemo1 {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        s.add("test1");
        s.add("test2");

        System.out.println(s);

        Iterator<String> it = s.iterator();
        while(it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }

        for (String string : s) {
            System.out.println(string);
        }

        s.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });

        s.forEach(str->System.out.println(str));
    }
}
