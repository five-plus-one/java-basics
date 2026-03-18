package com.fiveplusone.a09extendsdemo9;

public class Student extends Person{
    public Student(){
        // 子类构造方法中有个隐藏的super()去访问父类的无参构造
        super();
        System.out.println("子类的无参构造");
    }

    public Student(String name,int age){
        super(name,age);
    }

    @Override
    public String toString() {
        return "Student{name:"+name+",age:"+age+"}";
    }
}
