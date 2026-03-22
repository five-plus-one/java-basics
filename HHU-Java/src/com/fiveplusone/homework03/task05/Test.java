package com.fiveplusone.homework03.task05;

public class Test {
    public static void main(String[] args) {
        Hero h1 = new Hero("圣骑士·雷恩");
        Hero h2 = new Hero("魔法师·艾莉亚",80,30);
        h1.attack(h2);
        h1.attack(h2);
        h2.attack(h1);
        System.out.println("当前对局共加载了 " + Hero.getTotalHeroes() + " 个英雄角色。");
    }
}
