package com.fiveplusone.studentsystem;

import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
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
                case "1" -> addStudent();
                case "2" -> deleteStudent();
                case "3" -> updateStudent();
                case "4" -> queryStudent();
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
    public static void addStudent(){
        System.out.println("添加");
    }

    //删除学生
    public static void deleteStudent(){
        System.out.println("删除");
    }

    //修改学生
    public static void updateStudent(){
        System.out.println("修改");
    }

    //查询学生
    public static void queryStudent(){
        System.out.println("查询");
    }
}
