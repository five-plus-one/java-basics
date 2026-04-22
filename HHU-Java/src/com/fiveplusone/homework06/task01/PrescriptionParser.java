package com.fiveplusone.homework06.task01;

public class PrescriptionParser {

    public void validateAndParse(String rawData) throws Exception {

        String[] parts = rawData.split(":");

        if (parts.length < 3) {
            throw new ArrayIndexOutOfBoundsException("指令格式缺失");
        }

        String medicineName = parts[0];

        String doseString = parts[1].toLowerCase().replace("mg", "").trim();
        double mg = Double.parseDouble(doseString);

        int times = Integer.parseInt(parts[2].trim());

        if (mg > 1000) {
            throw new IllegalArgumentException("剂量超限，存在安全风险");
        }

        double singleMg = mg / times;
        System.out.println("药品：" + medicineName + ", 单次剂量：" + singleMg);
    }

    public static void main(String[] args) {
        PrescriptionParser parser = new PrescriptionParser();

        String[] tests = {
                "阿司匹林:500:2",
                "感冒灵:300",
                "布洛芬:1200mg:3"
        };
        for (String test : tests) {
            System.out.println("输入：" + test);
            try {
                parser.validateAndParse(test);
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println("捕获异常：" + e);
            } catch (Exception e) {
                System.out.println("捕获其他异常：" + e);
            }
            System.out.println("----------");
        }
    }
}
