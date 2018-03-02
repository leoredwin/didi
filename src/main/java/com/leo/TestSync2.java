/*
 * Package name:com.leo
 * File name:TestSync2.java
 * Date:2017-12-28 15:27
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-12-28 15:27
 */
public class TestSync2 implements Runnable {
    int b = 100;

    synchronized void m1() throws InterruptedException {
        int b = 1000;
        Thread.sleep(500); //6
        System.out.println("b=" + b);
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(250); //5
        b = 2000;
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync2 tt = new TestSync2();
        Thread t = new Thread(tt);  //1
        t.start(); //2

        tt.m2(); //3
        System.out.println("main thread b=" + tt.b); //4
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}