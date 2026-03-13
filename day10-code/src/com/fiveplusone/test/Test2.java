package com.fiveplusone.test;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("Zhangsan",23);
        Student s2 = new Student("Lisi",24);
        Student s3 = new Student("Wangwu",25);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.toString());
        }
    }
}
