package com.fiveplusone.homework07.task04;

import java.io.*;

public class StoreSalesDataBook {
    public static void main(String[] args) {
        String filePath = "D:\\testfile\\data\\sales.dat";
        File file = new File(filePath);

        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        System.out.println("正在将账本写入二进制文件...");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(1001);
            dos.writeDouble(18.5);
            dos.writeBoolean(true);

            dos.writeInt(1002);
            dos.writeDouble(32.0);
            dos.writeBoolean(false);

            dos.writeInt(1003);
            dos.writeDouble(9.9);
            dos.writeBoolean(true);

            System.out.println("写入成功！\n");
        } catch (IOException e) {
            System.out.println("写入文件时发生异常：" + e.getMessage());
            return;
        }

        double totalSales = 0.00;
        System.out.println("【账本读取结果】");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while(true){
                int orderId = dis.readInt();
                double amount = dis.readDouble();
                boolean isMember = dis.readBoolean();
                System.out.printf("订单编号：%d,金额：%.1f,是否会员：%b\n",orderId,amount,isMember);

                totalSales += amount;
            }
        } catch (EOFException e) {
            System.out.println("\n数据读取完毕。");
            System.out.printf("今日营业总额： %.1f 元\n", totalSales);
        } catch (IOException e) {
            System.out.println("读取文件时发生未知错误：" + e.getMessage());
        }
    }
}
