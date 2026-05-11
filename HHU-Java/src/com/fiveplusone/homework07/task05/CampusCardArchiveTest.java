package com.fiveplusone.homework07.task05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CampusCardArchiveTest {
    public static void main(String[] args) {
        String filePath = "D:\\testfile\\data\\cards.ser";
        File file = new File(filePath);

        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        List<CampusCard> cards = new ArrayList<>();
        cards.add(new CampusCard("2026001", "林语", 88.5, "123456"));
        cards.add(new CampusCard("2026002", "陈星", 120.0, "654321"));
        cards.add(new CampusCard("2026003", "苏畅", 45.5, "111111"));

        System.out.println("正在保存校园卡账户信息...");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(cards);
            System.out.println("保存成功！\n");
        } catch (IOException e) {
            System.out.println("存档失败：" + e.getMessage());
            return;
        }

        System.out.println("===反序列化后的校园卡账户===");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<CampusCard> loadedCards = (List<CampusCard>) ois.readObject();
            for(CampusCard card : loadedCards){
                System.out.println(card.toString());
            }
        } catch (IOException e) {
            System.out.println("读取文件失败：" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("找不到对应的类，反序列化失败：" + e.getMessage());
        }

    }
}
