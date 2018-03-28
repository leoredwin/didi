/*
 * Package name:com.leo
 * File name:SelectModel.java
 * Date:2018-03-09 10:10
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import java.util.*;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-03-09 10:10
 */
public class SelectModel {
    private static Set<List<Integer>> selectResult(List<Integer> arr) {
        Collections.sort(arr);//先对数组进行排序
        for (Integer aInteger : arr) {
            System.out.println(aInteger);
        }
        List<Integer> list3;
        Set<List<Integer>> setList = new HashSet<>();

        for (int i = 0; i < arr.size() - 2; i++) {
            int j = i + 1;
            int k = arr.size() - 1;
            while (j < k) {
                //先固定arr[i]不动，左右一定逼近;arr[j]太小，往前移动一位
                if (arr.get(i) + arr.get(j) + arr.get(k) < 0) {
                    j++;
                } else if (arr.get(i) + arr.get(j) + arr.get(k) > 0) {
                    k--;
                } else {
                    list3 = new ArrayList<>();
                    list3.add(arr.get(i));
                    list3.add(arr.get(j));
                    list3.add(arr.get(k));
                    setList.add(list3);
                    k--;
                }
            }
        }
        return setList;
    }


    public static void main(String[] args) {
        Integer[] list = {2, 1, 0, -1, 1, 4, 2, -2, -3};
        ArrayList<Integer> arrayList = new ArrayList<>(list.length);
        Collections.addAll(arrayList, list);
        Set<List<Integer>> output = selectResult(arrayList);
        for (List<Integer> list2 : output) {
            System.out.println(list2);
        }
    }
}