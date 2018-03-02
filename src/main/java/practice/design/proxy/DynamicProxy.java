/*
 * Package name:practice.design.proxy
 * File name:DynamicProxy.java
 * Date:2018-01-19 17:49
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.proxy;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-19 17:49
 */
public class DynamicProxy {

    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();

        HoseeDynamicimpel dynamicimpel = new HoseeDynamicimpel();
        HoseeDynamic proxy = (HoseeDynamic) myProxy.bind(dynamicimpel);
        System.out.println(proxy.sayhi());
    }
}