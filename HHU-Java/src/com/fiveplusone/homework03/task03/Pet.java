package com.fiveplusone.homework03.task03;

public class Pet {
    private String name;
    private double weight = 5;

    public Pet() {
    }

    public Pet(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void feed() {
        this.weight += 1.0;
    }
}
