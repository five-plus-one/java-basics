package com.fiveplusone.a01mymap;

import java.util.HashMap;
import java.util.Map;

public class A01MapDemo1 {
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();
        m.put("test1","test2");
        m.put("test3","test4");
        m.put("test1","test114514");
        String res = m.remove("test3");
        System.out.println(m + " " + res);
        m.clear();
        System.out.println(m);
        m.put("test1","test114514");
        System.out.println(m.containsKey("test1"));
        System.out.println(m.containsValue("test1"));
        System.out.println(m.isEmpty());
        System.out.println(m.size());
    }
}
