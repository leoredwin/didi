/*
 * Package name:com.leo
 * File name:WaitNotifyCase.java
 * Date:2018-01-05 14:59
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import java.util.concurrent.TimeUnit;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-05 14:59
 */
public class WaitNotifyCase {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(() -> {
            System.out.println("thread A is waiting to get lock");
            synchronized (lock) {
                try {
                    System.out.println("thread A get lock");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("thread A do wait method");
                    lock.wait();
                    System.out.println("wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("thread B is waiting to get lock");
            synchronized (lock) {
                System.out.println("thread B get lock");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                System.out.println("thread B do notify method");
            }
        }).start();
    }

}