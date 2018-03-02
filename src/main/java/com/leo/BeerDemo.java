/*
 * Package name:com.leo
 * File name:BeerDemo.java
 * Date:2018-03-02 11:35
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-03-02 11:35
 */
public class BeerDemo {

     /*
     * 一瓶啤酒2元钱，2个啤酒瓶可换一瓶啤酒，
     * 4个啤酒瓶盖可换一瓶，10元最多喝多少瓶啤酒？
     */

    public static int bottleCount = 0;
    public static int bottleCover = 0;

    public static void main(String[] args) {
        //喝的瓶数
        int count = 0;
        // 总钱数
        int money = 10;
        // 每瓶的单价数
        int price = 2;
        // 初始剩余的酒瓶数和酒瓶盖数目
        int bottle, cover;
        count = bottle = cover = money / price;

        System.out.println("总共能喝" + (count + getTotalBottle(bottle, cover))
                + "瓶啤酒，还剩酒瓶数目为" + bottleCount + "个,酒盖数目为" + bottleCover + "个。");
    }

    private static int getTotalBottle(int bottle, int cover) {
        if (bottle >= 2 || cover >= 4) {
            int bottleLeft = bottle / 2 + cover / 4;
            bottleCount = bottleLeft + bottle % 2;
            bottleCover = bottleLeft + cover % 4;
            return bottle / 2 + cover / 4 + getTotalBottle(bottleCount, bottleCover);
        }
        return 0;
    }
}