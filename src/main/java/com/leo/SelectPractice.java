/*
 * Package name:com.leo
 * File name:SelectPractice.java
 * Date:2018-03-09 10:39
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-03-09 10:39
 */
public class SelectPractice {

    public static void main(String[] args) {
        Integer[] a = {-2, -4, -1, 5, 0, 3, 4, 1, 2, 5, 0, 0, 0, -6};

        Set<List<Integer>> result = getResult(a);
        for (List<Integer> list2 : result) {
            System.out.println(list2);
        }
    }

    private static Set<List<Integer>> getResult(Integer[] a) {
        List<Integer> list = CollectionUtils.arrayToList(a);

        Collections.sort(list);

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> result;

        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            int k = list.size() - 1;

            while (j < k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result = new ArrayList<>();
                    result.add(list.get(i));
                    result.add(list.get(j));
                    result.add(list.get(k));
                    set.add(result);
                    k--;
                }
            }
        }

        return set;
    }
}