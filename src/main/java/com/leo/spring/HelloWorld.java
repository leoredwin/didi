/*
 * Package name:com.leo.spring
 * File name:HelloWorld.java
 * Date:2018-01-15 16:58
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.spring;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-15 16:58
 */
public class HelloWorld {
    private String message;

    public void getMessage() {
        System.out.println("Your message:" + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("Bean is going through init");
    }

    public void destroy() {
        System.out.println("Bean will destroy now");
    }
}