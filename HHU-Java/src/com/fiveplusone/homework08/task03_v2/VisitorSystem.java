package com.fiveplusone.homework08.task03_v2;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Visitor implements Comparable<Visitor> {
    String visitorId;
    String name;
    String reason;

    public Visitor(String visitorId, String name, String reason) {
        this.visitorId = visitorId;
        this.name = name;
        this.reason = reason;
    }

    // 必须重写，供 HashSet 去重使用
    @Override
    public int hashCode() {
        return visitorId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Visitor)) return false;
        Visitor other = (Visitor) obj;
        return this.visitorId.equals(other.visitorId);
    }

    // 必须实现，供 TreeSet 排序使用
    @Override
    public int compareTo(Visitor other) {
        return this.visitorId.compareTo(other.visitorId);
    }

    @Override
    public String toString() {
        return visitorId + " " + name + " " + reason;
    }
}

public class VisitorSystem {
    public static void main(String[] args) {
        // 准备包含重复项的数组
        Visitor[] records = {
                new Visitor("V001", "林羽", "校园参观"),
                new Visitor("V002", "陈星", "面试"),
                new Visitor("V003", "王宇", "参加讲座"),
                new Visitor("V001", "林羽", "校园参观"), // 重复项
                new Visitor("V004", "苏畅", "校友返校")
        };

        // 1. 去重且保留顺序
        Set<Visitor> linkedSet = new LinkedHashSet<>();
        for (Visitor v : records) {
            linkedSet.add(v);
        }

        System.out.println("【去重后，保留登记顺序】");
        for (Visitor v : linkedSet) {
            System.out.println(v);
        }

        // 2. 按编号排序 (直接将上面的 Set 倒入 TreeSet 即可排序)
        Set<Visitor> treeSet = new TreeSet<>(linkedSet);

        System.out.println("\n【按访客编号排序】");
        for (Visitor v : treeSet) {
            System.out.println(v);
        }
    }
}
