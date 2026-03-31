package com.fiveplusone.homework04.task01;

public class Test {
    public static void main(String[] args) {
        // 创建类
        DigitalProduct digitalProduct = new DigitalProduct();
        PhysicalProduct physicalProduct = new PhysicalProduct(3.5);
        // 打印运费
        System.out.println("数字商品的最终运费是" + digitalProduct.calculateShippingFee());
        System.out.println("重量为" + physicalProduct.getWeight() + "的商品的运费是" + physicalProduct.calculateShippingFee());
    }
}
