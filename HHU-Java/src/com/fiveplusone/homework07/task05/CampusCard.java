package com.fiveplusone.homework07.task05;

import java.io.Serial;
import java.io.Serializable;

public class CampusCard implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String studentId;
    private String name;
    private double balance;

    private transient String password;

    public static String schoolName = "河海智慧校园";

    public CampusCard(String studentId, String name, double balance, String password) {
        this.studentId = studentId;
        this.name =name;
        this.balance = balance;
        this.password = password;
    }

    @Override
    public String toString() {
        return "学号："+studentId + "，姓名：" + name + "，余额：" + balance + "，密码：" + password + "，学校：" + schoolName;
    }
}
