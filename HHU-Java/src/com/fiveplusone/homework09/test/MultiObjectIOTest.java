package com.fiveplusone.homework09.test;

import java.io.*;
import java.util.*; // 引入集合包

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int score;
    transient String password;

    public Student(String name, int score, String password) {
        this.name = name;
        this.score = score;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student[name=" + name + ", score=" + score + ", pwd=" + password + "]";
    }
}

public class MultiObjectIOTest {

    public static void main(String[] args) {
        File file = new File("D:\\students.data"); // 注意转义符

        // ==========================================
        // 第一步：把多个对象装进 List 集合，整体序列化
        // ==========================================
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            // 1. 创建一个装载对象的集合
            List<Student> list = new ArrayList<>();
            list.add(new Student("Alice", 95, "123"));
            list.add(new Student("Bob", 88, "456"));
            list.add(new Student("Charlie", 76, "789"));

            // 2. 核心：直接把整个 List 写入文件！(一次搞定)
            oos.writeObject(list);
            System.out.println("多个对象（List集合）已成功打包序列化！");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ==========================================
        // 第二步：反序列化，整体读出 List 集合
        // ==========================================
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            // 1. 核心：读出来的是一个大对象，强转为 List
            @SuppressWarnings("unchecked") // 考试可以不写这个压制警告的注解
            List<Student> readList = (List<Student>) ois.readObject();

            System.out.println("从文件中反序列化出的多个对象：");

            // 2. 遍历集合输出
            for (Student stu : readList) {
                System.out.println(stu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}