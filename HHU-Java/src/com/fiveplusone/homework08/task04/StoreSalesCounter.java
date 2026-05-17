package com.fiveplusone.homework08.task04;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StoreSalesCounter {
    public static void main(String[] args) {
        List<String> salesRecords = Arrays.asList(
                "矿泉水", "面包", "关东煮", "矿泉水", "饭团", "面包", "矿泉水", "关东煮"
        );

        System.out.println("【原始销售记录】");
        System.out.println(String.join(", ", salesRecords));
        System.out.println();

        Map<String, Integer> salesMap = new HashMap<>();
        for (String item : salesRecords) {
            if (salesMap.containsKey(item)) {
                int currentCount = salesMap.get(item);
                salesMap.put(item, currentCount + 1);
            } else {
                salesMap.put(item, 1);
            }
        }

        System.out.println("【销量统计】");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        Map<String, Integer> sortedSalesMap = new TreeMap<>(salesMap);
        System.out.println("【按商品名称排序后的统计】");
        for (Map.Entry<String, Integer> entry : sortedSalesMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        String targetItem = "矿泉水";
        int frequency = Collections.frequency(salesRecords, targetItem);
        System.out.println("使用 Collections.frequency 验证“" + targetItem + "”次数：" + frequency);
    }
}