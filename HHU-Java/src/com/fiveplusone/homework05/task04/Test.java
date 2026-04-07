package com.fiveplusone.homework05.task04;

public class Test {
    public static void main(String[] args) {
        RecycleLine line = new RecycleLine();
        Ewaste waste1 = new Phone();
        Ewaste waste2 = new Motherboard();
        Ewaste waste3 = new Ewaste(); // 假设这只是普通的塑料外壳垃圾
        line.processWaste(waste1);
        line.processWaste(waste2);
        line.processWaste(waste3);
    }
}
