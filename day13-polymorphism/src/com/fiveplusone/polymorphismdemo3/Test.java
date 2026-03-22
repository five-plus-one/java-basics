package com.fiveplusone.polymorphismdemo3;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("老王",30);
        Dog d = new Dog(1,"黄色");
        Cat c = new Cat(2,"黄色");
        p.keepPet(d,"骨头");
        p.keepPet(c,"鱼");
    }
}
