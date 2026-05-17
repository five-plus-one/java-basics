package com.fiveplusone.homework08.task03;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class CampusVisitorSystem {
    public static void main(String[] args) {
        // 1. 准备原始访客记录（使用 List 暂存，包含重复项）
        List<Visitor> originalRecords = new ArrayList<>();
        originalRecords.add(new Visitor("V001", "林羽", "校园参观"));
        originalRecords.add(new Visitor("V002", "陈星", "面试"));
        originalRecords.add(new Visitor("V003", "王宇", "参加讲座"));
        originalRecords.add(new Visitor("V001", "林羽", "校园参观")); // 重复记录
        originalRecords.add(new Visitor("V004", "苏畅", "校友返校"));

        // 输出原始访客记录
        System.out.println("【原始访客记录】");
        for (Visitor v : originalRecords) {
            System.out.println(v);
        }
        System.out.println();

        // 2. 使用 LinkedHashSet 去重并保留登记顺序
        // LinkedHashSet 会自动调用 Visitor 类的 hashCode 和 equals 方法来判断去重
        LinkedHashSet<Visitor> linkedHashSet = new LinkedHashSet<>(originalRecords);

        System.out.println("【去重后，保留登记顺序】");
        for (Visitor v : linkedHashSet) {
            System.out.println(v);
        }
        System.out.println();

        // 3. 使用 TreeSet 按访客编号排序
        // TreeSet 会自动调用 Visitor 类中重写的 compareTo 方法来进行排序和去重
        TreeSet<Visitor> treeSet = new TreeSet<>(originalRecords);

        System.out.println("【按访客编号排序】");
        for (Visitor v : treeSet) {
            System.out.println(v);
        }
    }
}
