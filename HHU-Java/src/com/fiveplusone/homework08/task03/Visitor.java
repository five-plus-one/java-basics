package com.fiveplusone.homework08.task03;

import java.util.Objects;

public class Visitor implements Comparable<Visitor> {
    private String visitorId;
    private String name;
    private String reason;

    public Visitor(String visitorId, String name, String reason) {
        this.visitorId = visitorId;
        this.name = name;
        this.reason = reason;
    }

    // Getter 和 Setter 方法
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return visitorId + " " + name + " " + reason;
    }

    // 重写 equals 方法：只要三个属性内容完全一致，就认为是同一个对象
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(visitorId, visitor.visitorId) &&
                Objects.equals(name, visitor.name) &&
                Objects.equals(reason, visitor.reason);
    }

    // 重写 hashCode 方法：结合三个属性生成哈希值
    @Override
    public int hashCode() {
        return Objects.hash(visitorId, name, reason);
    }

    // 实现 Comparable 接口，定义 TreeSet 的默认排序规则（按访客编号升序）
    @Override
    public int compareTo(Visitor other) {
        return this.visitorId.compareTo(other.visitorId);
    }
}
