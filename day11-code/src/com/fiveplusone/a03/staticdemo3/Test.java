package com.fiveplusone.a03.staticdemo3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student stu1 = new Student("ZhangSan",23,"男");
        Student stu2 = new Student("LiSi",24,"女");
        Student stu3 = new Student("WangWu",25,"男");

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        int maxAge = StudentUtil.getMaxAageStudent(list);
        System.out.println(maxAge);
    }
}
