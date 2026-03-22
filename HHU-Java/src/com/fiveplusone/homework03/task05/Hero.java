package com.fiveplusone.homework03.task05;

public class Hero {
    //实例变量
    private String name;
    private int hp;
    private int attackPower;

    //静态变量
    private static int totalHeroes = 0;

    //构造方法
    Hero(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        totalHeroes++;
    }

    Hero(String name) {
        this(name, 100, 20);
    }

    //实例方法
    public void attack(Hero target) {
        target.hp -= this.attackPower;
        if (target.hp <= 0) {
            target.hp = 0; //防止伤害目标血量为负
        }
        System.out.println(this.name + " 攻击了 " + target.name + " ，" + target.name + "剩余血量：" + target.hp);
    }

    //静态方法
    public static int getTotalHeroes(){
        return totalHeroes;
    }
}
