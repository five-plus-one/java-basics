package com.fiveplusone.a01.staticdemo1;

public class StudentTest {
    public static void main(String[] args) {
        Student.teacherName = "test";

        Student s1 = new Student();
        s1.setName("Zhangsan");
        s1.setAge(23);
        s1.setGender("男");

        Student s2 = new Student();

        s2.setName("Lisi");
        s2.setAge(24);
        s2.setGender("女");

        s1.show();
        s2.show();
    }
}
