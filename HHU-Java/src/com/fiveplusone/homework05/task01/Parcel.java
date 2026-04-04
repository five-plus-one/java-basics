package com.fiveplusone.homework05.task01;

public abstract class Parcel {
    double weight;

    public Parcel(double weight) {
        this.weight = weight;
    }

    public void printInfo(){
        System.out.println("包裹类型：" + this.getParcelType() + "；包裹重量:"+  weight  + "kg；运费：" + this.calculateCost());
    }

    public abstract double calculateCost();
    public abstract String getParcelType();
}
