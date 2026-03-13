package com.fiveplusone.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        loop: while (true) {
            System.out.println("--------");
            System.out.println("1.添加");
            System.out.println("2.删除");
            System.out.println("3.修改");
            System.out.println("4.查询");
            System.out.println("5.退出");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch(choose){
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
//                    break loop;
                    System.exit(0); //停止虚拟机运行
                }
                default -> System.out.println("您的输入有误");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("请输入学生id");
            id = sc.next();
            boolean flag = contains(list, id);
            if (flag) {
                System.out.println("该id已存在，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生家庭住址");
        String address = sc.next();

        Student stu = new Student(id,name,age,address);
        list.add(stu);
        System.out.println("添加成功");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("删除");
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list){
        System.out.println("修改");
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list){
        if(list.size() == 0){
            System.out.println("当前无学生信息，请添加后查询");
            return;
        }
        System.out.println("id\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    //判断id在集合中是否存在
    public static boolean contains(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if(stu.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
