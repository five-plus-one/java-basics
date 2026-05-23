package com.fiveplusone.a04set;

import java.util.HashSet;
import java.util.Objects;

public class A02_HashSetDemo1 {
    public static void main(String[] args) {
        Student s1 = new Student("Zhangsan",23);
        Student s2 = new Student("Zhangsan",23);
        Student s3 = new Student("Wangwu",23);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        HashSet<Student> hs = new HashSet<>();
        System.out.println(hs.add(s1));
        System.out.println(hs.add(s2));
        System.out.println(hs.add(s3));

        System.out.println(hs);
    }
}

