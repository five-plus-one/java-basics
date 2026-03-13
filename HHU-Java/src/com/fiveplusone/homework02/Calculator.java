package com.fiveplusone.homework02;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 计算器 ===");
        System.out.println("提示：请输入完整表达式，以空格分隔（如：5 + 3）");
        System.out.println("输入 'exit' 退出程序\n");

        // 使用 while(true) 实现连续计算
        while (true) {
            System.out.print("请输入表达式: ");
            String firstInput = scanner.next();

            // 1. 判断是否退出
            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("计算结束，欢迎下次使用！");
                break;
            }

            // 2. 解析数字和运算符
            double num1 = Double.parseDouble(firstInput);
            String operator = scanner.next();
            double num2 = Double.parseDouble(scanner.next());

            double result = 0;
            boolean isValid = true; // 标记本次计算是否有效

            // 3. 使用 switch 进行多分支计算
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("【错误】除数不能为 0！");
                        isValid = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("【错误】不支持的运算符: " + operator);
                    isValid = false;
                    break;
            }

            // 4. 输出结果
            if (isValid) {
                System.out.println("计算结果: " + num1 + " " + operator + " " + num2 + " = " + result + "\n");
            } else {
                System.out.println(); // 格式美化，空一行
            }
        }
    }
}
