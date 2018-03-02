/*
 * Package name:com.leo.gc
 * File name:FinalizerTest.java
 * Date:2018-01-17 16:21
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.gc;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-17 16:21
 */
public class FinalizerTest {
    public static FinalizerTest object;
    public void isAlive() {
        System.out.println("I'm alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("method finalize is running");
        object = this;
    }

    public static void main(String[] args) throws Exception {
        object = new FinalizerTest();

        // 第一次执行，finalize方法会自救
        object = null;
        System.gc();

        Thread.sleep(500);
        if (object != null) {
            object.isAlive();
        } else {
            System.out.println("I'm dead");
        }

        // 第二次执行，finalize方法已经执行过
        object = null;
        System.gc();

        Thread.sleep(500);
        if (object != null) {
            object.isAlive();
        } else {
            System.out.println("I'm dead");
        }
    }
}
