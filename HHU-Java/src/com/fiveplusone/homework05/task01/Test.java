package com.fiveplusone.homework05.task01;

public class Test {
    public static void main(String[] args) {
        Parcel[] parcels = new Parcel[]{
                new StandardParcel(10),
                new ExpressParcel(20),
                new StandardParcel(15),
                new ExpressParcel(25)
        };
        System.out.println("===包裹信息===");
        for (int i = 0; i < parcels.length; i++) {
            parcels[i].printInfo();
        }
        System.out.println("========");
        System.out.println("总运费：" + AccountingSystem.calculateTotalRevenue(parcels));
    }
}
