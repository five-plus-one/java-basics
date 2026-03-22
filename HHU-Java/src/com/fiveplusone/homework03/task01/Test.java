package com.fiveplusone.homework03.task01;

public class Test {
    public static void main(String[] args) {
        // 依次创建3个员工对象
        Employee e1 = new Employee("林羽");
        Employee e2 = new Employee("陈星");
        Employee e3 = new Employee("苏畅");
        // 显示每个员工的信息
        e1.show();
        e2.show();
        e3.show();
    }
}
