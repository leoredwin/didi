package com.leo.bootstrap;


/**
 * Created by Leo on 2016/8/24.
 * 将一行数据 line
 * 变成一个结构体PO
 */
public interface TransLineFunction<T> {
    T deal(String line);
}
