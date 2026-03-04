package com.fiveplusone.test;

public class Test3 {
    static void main(String[] args) {
        double area1 = getArea(5.3,1.7);
        double area2 = getArea(2.4,2.7);
        if(area1<area2){
            System.out.println("矩形2的面积更大");
        }else {
            System.out.println("矩形1的面积更大");
        }
    }
    public static double getArea(double len,double width){
        double area = len * width;
        return area;
    }
}
