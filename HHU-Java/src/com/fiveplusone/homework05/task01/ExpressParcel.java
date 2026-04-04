package com.fiveplusone.homework05.task01;

public class ExpressParcel extends Parcel{

    public ExpressParcel(double weight) {
        super(weight);
    }

    @Override
    public double calculateCost() {
        return weight * 20 + 50;
    }

    @Override
    public String getParcelType() {
        return "特快包裹";
    }
}
