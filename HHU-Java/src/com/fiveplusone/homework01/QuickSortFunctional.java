package com.fiveplusone.homework01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 函数式风格的快速排序实现。
 * 使用 Java Streams API，强调可读性和声明式编程。
 * 注意：这种方式在性能上不如原地排序（in-place sort），因为会创建大量临时列表。
 */
public class QuickSortFunctional {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        // 选择第一个元素作为基准
        Integer pivot = list.get(0);

        // 获取剩余元素
        List<Integer> tail = list.subList(1, list.size());

        // 过滤小于等于基准的元素
        List<Integer> smaller = tail.stream()
                .filter(i -> i <= pivot)
                .collect(Collectors.toList());

        // 过滤大于基准的元素
        List<Integer> greater = tail.stream()
                .filter(i -> i > pivot)
                .collect(Collectors.toList());

        // 递归排序并合并结果
        return Stream.concat(
                Stream.concat(sort(smaller).stream(), Stream.of(pivot)),
                sort(greater).stream()
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10, 5, 2, 3, 7, 8, 1);
        System.out.println("原始列表: " + data);
        List<Integer> sorted = sort(data);
        System.out.println("排序后列表: " + sorted);
    }
}
