/*
 * Package name:com.leo
 * File name:CountTask.java
 * Date:2018-01-10 14:21
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-10 14:21
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;///阈值
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    private static HashMap hashMap = new HashMap();
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += 1;
            }
        } else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            invokeAll(leftTask, rightTask);
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//
//        CountTask countTask = new CountTask(1, 4);
//
//        Future<Integer> result = forkJoinPool.submit(countTask);
//        try {
//            System.out.println(result.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println(new Date(1515556286000L));

    }
}