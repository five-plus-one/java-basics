package com.fiveplusone.homework01;

import java.util.Arrays;

/**
 * 快速排序算法实现
 * 核心思想：选取一个基准值（pivot），将数组分为两部分：
 *   - 左侧：所有元素均 <= 基准值
 *   - 右侧：所有元素均 >= 基准值
 * 然后对两部分递归执行同样的操作，最终得到有序数组。
 * 时间复杂度：平均 O(n log n)，最坏 O(n²)
 * 空间复杂度：O(log n)（递归调用栈）
 */
public class QuickSort {

    /**
     * 快速排序入口方法（对外暴露的公共接口）
     *
     * @param arr 待排序的整型数组
     */
    public static void quickSort(int[] arr) {
        // 边界情况处理：数组为 null 或元素个数 <= 1 时，无需排序，直接返回
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 调用核心递归方法，初始范围为整个数组 [0, length-1]
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 核心递归排序方法
     * 每次调用都会确定基准值的最终位置，然后对左右子数组继续递归
     *
     * @param arr   待排序数组
     * @param low   当前排序区间的起始索引（包含）
     * @param high  当前排序区间的结束索引（包含）
     */
    private static void sort(int[] arr, int low, int high) {
        // 递归终止条件：当区间只剩一个或零个元素时，该区间已有序，无需继续处理
        if (low >= high) {
            return;
        }

        // ── 第一步：分区 ──────────────────────────────────────────────────────
        // 对 arr[low..high] 进行分区，返回基准值最终所在的索引 pivotIndex
        // 分区完成后，arr[pivotIndex] 已经在其最终排序位置上
        int pivotIndex = partition(arr, low, high);

        // ── 第二步：递归排序左子数组 ──────────────────────────────────────────
        // 处理基准值左侧的子数组 [low, pivotIndex - 1]
        // 这些元素全部 <= arr[pivotIndex]，需继续排序
        sort(arr, low, pivotIndex - 1);

        // ── 第三步：递归排序右子数组 ──────────────────────────────────────────
        // 处理基准值右侧的子数组 [pivotIndex + 1, high]
        // 这些元素全部 >= arr[pivotIndex]，需继续排序
        sort(arr, pivotIndex + 1, high);
    }

    /**
     * 分区方法（Lomuto 分区方案）
     * 以数组最后一个元素 arr[high] 作为基准值（pivot）。
     * 遍历完成后，将基准值交换到"左小右大"的分界位置，并返回该位置索引。
     *
     * 分区过程示意（以 [3, 6, 8, 10, 1, 2, 1] 为例，pivot = 1）：
     *
     *   初始：  3  6  8  10  1  2 | 1  ← pivot
     *           ↑
     *         storeIndex = low - 1 = -1（虚拟位置，表示"尚无小于pivot的元素"）
     *
     *   i=0: arr[0]=3 > 1，不交换
     *   i=1: arr[1]=6 > 1，不交换
     *   ...（均大于 pivot，storeIndex 不变）
     *   i=4: arr[4]=1 <= 1，storeIndex++ → 0，swap(arr,0,4) → [1,6,8,10,3,2,1]
     *   i=5: arr[5]=2 > 1，不交换
     *   最后：swap(arr, storeIndex+1, high) → swap(arr,1,6)
     *   结果：[1, 1, 8, 10, 3, 2, 6]，返回 pivotIndex=1 ✓
     *
     * @param arr  待分区数组
     * @param low  分区区间起始索引
     * @param high 分区区间结束索引（同时也是基准值所在位置）
     * @return     基准值在分区完成后的最终索引
     */
    private static int partition(int[] arr, int low, int high) {
        // 取区间最后一个元素作为基准值
        int pivot = arr[high];

        // storeIndex 指向"最后一个已确认小于等于基准值的元素"的位置
        // 初始设为 low - 1，表示尚未找到任何小于等于基准值的元素
        int storeIndex = low - 1;

        // 遍历 [low, high-1]，注意不包含 high（因为 high 是基准值本身）
        for (int i = low; i < high; i++) {
            // 如果当前元素 <= 基准值，将其归入"左侧小区"
            if (arr[i] <= pivot) {
                // storeIndex 右移一位，腾出位置给当前小元素
                storeIndex++;
                // 将当前元素 arr[i] 与 arr[storeIndex] 交换
                // 效果：把小元素不断"推到"左侧区域
                swap(arr, storeIndex, i);
            }
            // 如果 arr[i] > pivot，无需操作，继续向右遍历
        }

        // 遍历结束后，storeIndex+1 就是基准值的正确位置：
        //   - 它左侧（含 storeIndex）的所有元素均 <= pivot
        //   - 它右侧的所有元素均 > pivot
        // 将基准值（arr[high]）与 arr[storeIndex+1] 交换，放到正确位置
        swap(arr, storeIndex + 1, high);

        // 返回基准值的最终索引
        return storeIndex + 1;
    }

    /**
     * 原地交换数组中两个元素的位置
     *
     * @param arr 目标数组
     * @param i   第一个元素的索引
     * @param j   第二个元素的索引
     */
    private static void swap(int[] arr, int i, int j) {
        // 使用临时变量完成三步交换，避免数据丢失
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = temp;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 测试入口
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ── 测试用例 1：普通乱序数组 ──────────────────────────────────────────
        int[] arr1 = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("排序前: " + Arrays.toString(arr1));
        quickSort(arr1);
        System.out.println("排序后: " + Arrays.toString(arr1));
        // 期望：[1, 1, 2, 3, 6, 8, 10]

        // ── 测试用例 2：已排序数组（最坏情况之一）────────────────────────────
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\n排序前: " + Arrays.toString(arr2));
        quickSort(arr2);
        System.out.println("排序后: " + Arrays.toString(arr2));
        // 期望：[1, 2, 3, 4, 5]

        // ── 测试用例 3：逆序数组 ──────────────────────────────────────────────
        int[] arr3 = {9, 7, 5, 3, 1};
        System.out.println("\n排序前: " + Arrays.toString(arr3));
        quickSort(arr3);
        System.out.println("排序后: " + Arrays.toString(arr3));
        // 期望：[1, 3, 5, 7, 9]

        // ── 测试用例 4：包含重复元素 ──────────────────────────────────────────
        int[] arr4 = {4, 2, 4, 2, 4};
        System.out.println("\n排序前: " + Arrays.toString(arr4));
        quickSort(arr4);
        System.out.println("排序后: " + Arrays.toString(arr4));
        // 期望：[2, 2, 4, 4, 4]

        // ── 测试用例 5：单元素数组（边界情况）────────────────────────────────
        int[] arr5 = {42};
        System.out.println("\n排序前: " + Arrays.toString(arr5));
        quickSort(arr5);
        System.out.println("排序后: " + Arrays.toString(arr5));
        // 期望：[42]

        // ── 测试用例 6：空数组（边界情况）────────────────────────────────────
        int[] arr6 = {};
        System.out.println("\n排序前: " + Arrays.toString(arr6));
        quickSort(arr6);
        System.out.println("排序后: " + Arrays.toString(arr6));
        // 期望：[]

        // ── 测试用例 7：null（边界情况）──────────────────────────────────────
        System.out.println("\n排序前: null");
        quickSort(null);
        System.out.println("排序后: null（未抛出异常，处理正常）");
    }
}