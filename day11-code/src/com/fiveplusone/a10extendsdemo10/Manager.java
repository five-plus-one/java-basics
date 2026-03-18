package com.fiveplusone.a10extendsdemo10;

public class Manager extends Employee{
    private double bonus;


    public Manager() {
    }

    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    /**
     * 获取
     * @return bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * 设置 bonus
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work(){
        System.out.println("管理");
    }

}
