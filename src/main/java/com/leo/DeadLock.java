/*
 * Package name:com.leo
 * File name:DeadLock.java
 * Date:2018-01-05 14:23
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-05 14:23
 */
public class DeadLock {
    private static String a = "A";
    private static String b = "B";

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }

    private void deadLock(){
        Thread t1=new Thread(() -> {
            synchronized(a){
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(b){
                    System.out.println("1 ");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized(b){
                synchronized(a){
                    System.out.println(2);
                }
            }
        });
        t1.start();
        t2.start();
    }
}