package com.fiveplusone.a04set;

import java.util.TreeSet;

public class A04_TreeSetDemo2 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",23);
        Student s2 = new Student("lisi",24);
        Student s3 = new Student("wangwu",24);

        TreeSet<Student> ts = new TreeSet<>();

        ts.add(s3);
        ts.add(s2);
        ts.add(s1);
        System.out.println(ts);
    }

}
