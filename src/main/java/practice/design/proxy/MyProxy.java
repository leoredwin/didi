/*
 * Package name:practice.design.proxy
 * File name:MyProxy.java
 * Date:2018-01-19 17:46
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-19 17:46
 */
public class MyProxy implements InvocationHandler {
    Object object;

    public Object bind(Object o) {
        this.object = o;
        return Proxy.newProxyInstance(o.getClass().getClassLoader()
                , o.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I'm proxy!");
        Object res = method.invoke(object, args);
        return res;
    }
}