/*
 * Package name:com.leo
 * File name:test.java
 * Date:2017-12-13 17:22
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import java.util.Arrays;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-12-13 17:22
 */
public class test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[]{2, 1, 6, 7, 8, 5, 3, 5};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int begin, int end) {
        //
        int tbegin = begin, tend = end;
        // 将第一个值作为快排序的分界值
        int pivot = a[begin];
        while (tbegin < tend) {
            // 如果两个游标没有交集，或者后面一直大于或等于分界值就一直向前移动
            while (tbegin < tend && a[tend] >= pivot) {
                --tend;
            }
            a[tbegin] = a[tend];
            // 如果两个游标没有交集，或者前面是小于或等于分界值，就一直向后头移动
            while (tbegin < tend && a[tbegin] <= pivot) {
                ++tbegin;
            }
            a[tend] = a[tbegin];

        }
        // 将临界值赋值给游标的交集的地方
        a[tbegin] = pivot;
        if (begin < tend) {
            // 递归排序游标的左边
            quickSort(a, begin, tend - 1);
        }
        if (tbegin < end) {
            // 递归排序游标的右边
            quickSort(a, tbegin + 1, end);
        }

    }

    private static void BubbleSort(int[] arr) {
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        for (int i = 1; i < arr.length; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectSort(int[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = min + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    int temp = a[min];
                    a[min] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

}