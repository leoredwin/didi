/*
 * Package name:com.leo
 * File name:AtomicInteger.java
 * Date:2018-01-03 16:02
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
 * @since 2018-01-03 16:02
 */
public class WaitNotify{
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Wait(), "wait thread");
        A.start();
        TimeUnit.SECONDS.sleep(2);
        Thread B = new Thread(new Notify(), "notify thread");
        B.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true");
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                flag = false;
                lock.notifyAll();
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}