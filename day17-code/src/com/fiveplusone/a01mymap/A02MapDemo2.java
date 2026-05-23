package com.fiveplusone.a01mymap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A02MapDemo2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        Set<String> keys =  map.keySet();

        for (String key : keys) {
            System.out.println(key);
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
