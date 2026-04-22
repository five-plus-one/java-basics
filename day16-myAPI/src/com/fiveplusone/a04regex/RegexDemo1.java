package com.fiveplusone.a04regex;

public class RegexDemo1 {
    public static void main(String[] args) {
        String qq = "12345678";
        if(qq.matches("[1-9]\\d{5,19}")){
            System.out.println("符合要求");
        }else{
            System.out.println("不符合要求");
        }
    }
}
