package com.fiveplusone.homework03.task01;

/**
 * 员工类 - 用于表示员工
 * 实现了工号自动分配功能
 */
public class Employee {
    // 实例变量
    private String name; //姓名
    private int id; //工号

    //静态变量
    // 被所有Employee对象共享
    private static int nextId = 1001; //下一个可用的工号，初始值1001
    private static String companyName = "星辰科技"; //公司名称

    //构造方法
    //  创建员工对象时自动调用
    //  功能：1. 设置员工姓名  2. 自动分配唯一工号  3. 工号计数器自增
    public Employee(String name){
        this.name = name;
        this.id = nextId;
        nextId++;
    }
    // 成员方法
    // 显示完整员工信息
    public void show(){
        System.out.println(companyName + " - " + name + " - " + id);
    }
}
