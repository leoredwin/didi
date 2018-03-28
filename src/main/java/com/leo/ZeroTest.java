/*
 * Package name:com.leo
 * File name:ZeroTest.java
 * Date:2018-03-05 14:17
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import java.util.Scanner;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-03-05 14:17
 */
public class ZeroTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入阶乘数：");
        int a = scanner.nextInt();
        int count = 0;
        for (; ; ) {
            a = a / 5;
            if (a == 0) {
                break;
            } else {
                count += a;
            }
        }
        System.out.println("阶乘结果后面的零的个数为:" + count);
    }
}