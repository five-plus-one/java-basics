package com.fiveplusone.homework05.task01;

public class AccountingSystem {
    private AccountingSystem(){}

    public static double calculateTotalRevenue(Parcel[] parcels) {
        double totalRevenue = 0.0;
        for (int i = 0; i < parcels.length; i++) {
            totalRevenue += parcels[i].calculateCost();
        }
        return totalRevenue;
    }
}
