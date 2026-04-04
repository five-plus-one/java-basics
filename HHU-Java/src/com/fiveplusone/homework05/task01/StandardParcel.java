package com.fiveplusone.homework05.task01;

public class StandardParcel extends Parcel{
    public StandardParcel(double weight) {
        super(weight);
    }

    @Override
    public double calculateCost() {
        return weight * 10;
    }

    @Override
    public String getParcelType() {
        return "标准包裹";
    }
}
