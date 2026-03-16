package com.fiveplusone.a07extendsdemo3;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.lunch();
        OverseasStudent os = new OverseasStudent();
        os.lunch();
    }
}

class Person {
    public void eat() {
        System.out.println("吃米饭");
    }

    public void drink() {
        System.out.println("喝开水");
    }
}
class OverseasStudent extends Person{
    public void lunch(){
        this.eat();
        this.drink();

        super.eat();
        super.drink();
    }

    public void eat(){
        System.out.println("吃意大利面");
    }

    public void drink(){
        System.out.println("喝凉水");
    }
}
class Student extends Person {
    public void lunch() {
        //先在本类中查看eat和drink方法，就会调用本类中的方法，如果没有，就会去父类中查看
        eat();
        drink();
        super.eat();
        super.drink();
    }


}