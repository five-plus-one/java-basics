package com.fiveplusone.test;

public class GirlFriend {
    private int age;
    private String name;
    //set(赋值)
    public void setAge(int a){
        if(a >=18 && a <=50){
            age = a;
        }else{
            System.out.println("非法数据");
        }
    }
    //get(获取)
    public int getAge(){
        return age;
    }

    public void SetName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

}
