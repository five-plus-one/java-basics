package com.fiveplusone.homework01;

import java.util.Arrays;

/**
 * 经典风格的快速排序实现。
 * 使用 Lomuto 分区方案，代码结构清晰，适合教学。
 */
public class QuickSortClassic {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partitionIndex 是分区索引，arr[partitionIndex] 现在在正确的位置
            int partitionIndex = partition(arr, low, high);

            // 递归排序元素
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = arr[high];
        int i = (low - 1); // 较小元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (arr[j] <= pivot) {
                i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和 arr[high] (或基准)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        QuickSortClassic sorter = new QuickSortClassic();
        int[] data = {8, 7, 2, 1, 0, 9, 6};
        System.out.println("原始数组: " + Arrays.toString(data));
        sorter.sort(data);
        System.out.println("排序后数组: " + Arrays.toString(data));
    }
}
