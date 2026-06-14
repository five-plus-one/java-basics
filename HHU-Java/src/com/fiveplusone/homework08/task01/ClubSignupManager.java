package com.fiveplusone.homework08.task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class ClubSignupManager {
    public static void main(String[] args) {
        // 1. 创建 ArrayList<Student> 保存报名名单
        ArrayList<Student> signupList = new ArrayList<>();

        // 2. 添加 4 名学生到报名名单中
        signupList.add(new Student("2026001", "林羽", "计算机2301"));
        signupList.add(new Student("2026002", "陈星", "软件2302"));
        signupList.add(new Student("2026003", "苏畅", "计算机2301"));
        signupList.add(new Student("2026004", "王宇", "人工智能2301"));

        // 打印原始名单
        System.out.println("【原始报名名单】");
        for (Student student : signupList) {
            System.out.println(student);
        }
        System.out.println();

        // 3. 根据索引输出第 2 名报名学生 (索引为 1)
        System.out.println("第 2 名报名学生：" + signupList.get(1));
        System.out.println();

        // 4. 根据学号查询某个学生是否已经报名 (查询学号：2026003)
        String targetId = "2026003";
        System.out.println("查询学号 " + targetId + "：");
        for (Student student : signupList) {
            if (student.getStudentId().equals(targetId)) {
                System.out.println("已报名：" + student.getName());
                break;
            }
        }
        System.out.println();

        // 5. 修改某个学生的班级信息
        String updateId = "2026004";
        String newClazz = "计算机2302";
        System.out.println("修改 " + updateId + " 的班级为：" + newClazz);
        for (Student student : signupList) {
            if (student.getStudentId().equals(updateId)) {
                student.setClazz(newClazz);
                break;
            }
        }

        // 6. 删除指定学号的学生 必须使用 Iterator
        String removeId = "2026001";
        System.out.println("取消报名：" + removeId);
        System.out.println();

        Iterator<Student> iterator = signupList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(removeId)) {
                iterator.remove(); // 严格调用迭代器自身的 remove 方法
            }
        }

        // 7. 输出最终报名名单
        System.out.println("【最终报名名单 - 增强for遍历】");
        for (Student student : signupList) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("【最终报名名单 - Lambda表达式遍历】");
        signupList.forEach(student -> System.out.println(student));

        signupList.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
        // 或者使用方法引用：signupList.forEach(System.out::println);
    }
}