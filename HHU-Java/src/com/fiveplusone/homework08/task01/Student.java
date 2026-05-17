package com.fiveplusone.homework08.task01;

public class Student {
    private String studentId;
    private String name;
    private String clazz;

    public Student(String studentId, String name, String clazz) {
        this.studentId = studentId;
        this.name = name;
        this.clazz = clazz;
    }

    // Getter 和 Setter 方法
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " - " + clazz;
    }
}