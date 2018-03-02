/*
 * Package name:com.leo
 * File name:practice.java
 * Date:2017-12-20 17:06
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
 * @since 2017-12-20 17:06
 */
public class practice {
    public static void main(String[] args) {
        int[] a = new int[]{9, 6, 1, 6, 2, 7, 4, 2, 8};
        //排序
        quickSort(0, a.length - 1, a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int begin, int end, int[] a) {
       for (int i=0;i<a.length-1;i++){
           for (int j = i+1;j<a.length;j++){
               if (a[i]>a[j]){
                   int temp = a[i];
                   a[i]=a[j];
                   a[j]=temp;
               }
           }
       }
    }
}