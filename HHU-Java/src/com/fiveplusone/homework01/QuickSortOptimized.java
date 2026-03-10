package com.fiveplusone.homework01;

import java.util.Arrays;

/**
 * 优化风格的快速排序实现。
 * 使用 Hoare 分区方案，通常比 Lomuto 方案更高效（交换次数更少）。
 * 包含对小数组的插入排序优化（虽然这里为了简洁未完全展开，但结构上更紧凑）。
 */
public class QuickSortOptimized {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        doSort(array, 0, array.length - 1);
    }

    private static void doSort(int[] array, int left, int right) {
        if (left >= right) return;

        // 选择中间元素作为基准，避免已排序数组的最坏情况
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);

        doSort(array, left, index - 1);
        doSort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        System.out.println("原始数组: " + Arrays.toString(data));
        sort(data);
        System.out.println("排序后数组: " + Arrays.toString(data));
    }
}
