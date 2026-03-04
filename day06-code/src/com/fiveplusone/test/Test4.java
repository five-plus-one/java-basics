package com.fiveplusone.test;

public class Test4 {
    static void main(String[] args) {
        compare(10,20);
        compare((byte)10,(byte)20);
        compare((short)10,(short)20);
        compare((long)10,(long)20);
    }

    public static void compare(byte b1,byte b2){
        System.out.println("byte");
        System.out.println(b1==b2);
    }
    public static void compare(short s1,short s2){
        System.out.println("short");
        System.out.println(s1==s2);
    }
    public static void compare(int i1,int i2){
        System.out.println("int");
        System.out.println(i1==i2);
    }
    public static void compare(long l1,long l2){
        System.out.println("long");
        System.out.println(l1==l2);
    }
}
