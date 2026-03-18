package com.fiveplusone.a10extendsdemo10;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager("001", "ZhangSan", 15000, 8000);
        System.out.println(m.getId() + "," + m.getName() +
                "," + m.getSalary() + "," + m.getBonus());
        Cook c = new Cook();
        c.setId("002");
        c.setName("LiSi");
        c.setSalary(8000);
        System.out.println(c.getId() + "," + c.getName() + "," + c.getSalary());
    }
}
