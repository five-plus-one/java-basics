package com.fiveplusone.test;

public class GirlFriend {
    private int age;
    private String name;
    //set(赋值)
    public void setAge(int age){
        if(age >=18 && age <=50){
            this.age = age;
        }else{
            System.out.println("非法数据");
        }
    }
    //get(获取)
    public int getAge(){
        return age;
    }

    public void SetName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
