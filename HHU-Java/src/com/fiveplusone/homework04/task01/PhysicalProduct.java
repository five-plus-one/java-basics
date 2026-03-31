package com.fiveplusone.homework04.task01;

// 子类：实体产品
public class PhysicalProduct extends Product{
    private double weight;
    PhysicalProduct(double weight){
        this.weight = weight;
    }

    @Override
    public double calculateShippingFee() {
        return weight * 5 + 10;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
