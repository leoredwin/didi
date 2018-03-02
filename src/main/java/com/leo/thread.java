/*
 * Package name:com.leo
 * File name:thread.java
 * Date:2018-01-03 14:21
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import java.util.concurrent.*;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-03 14:21
 */
public class thread {

    private static Executor executor = Executors.newFixedThreadPool(10);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Future<String> future = executorService.submit(new Task());
        System.out.println("do other things");
        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Task implements Callable<String> {


        @Override
        public String call() throws Exception {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "this is future case";
        }
    }
}