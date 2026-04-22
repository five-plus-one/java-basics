package com.fiveplusone.homework06.task04;

public class LabEquipment {
    public static int executeExperiment(int data) {
        int result;
        try {
            System.out.println("[设备日志]:资源已加锁");
            result = 100 / data;
            return result;
        } catch (ArithmeticException e) {
            System.out.println("[设备日志]:实验过程发生异常");
            result = -1;
            return result;
        } finally {
            System.out.println("[设备日志]:资源已释放，设备解锁");
        }
    }

    public static void main(String[] args) {
        System.out.println("测试1 (data = 10)");
        int res1 = executeExperiment(10);
        System.out.println("方法最终返回值: " + res1);
        System.out.println("\n----------\n");
        System.out.println("测试2 (data = 0)");
        int res2 = executeExperiment(0);
        System.out.println("方法最终返回值: " + res2);
    }
}
