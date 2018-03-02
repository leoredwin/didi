/*
 * Package name:practice.design.proxy
 * File name:CGlibHosee.java
 * Date:2018-01-19 19:47
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-19 19:47
 */
class CGlibHosee {
    public String sayhi() {
        return "Welcome oschina hosee's blog";
    }
}

class CGlibHoseeProxy {
    Object object;

    public Object bind(final Object target) {
        this.object = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("I'm proxy!");
                return method.invoke(target, objects);
            }
        });
        return enhancer.create();
    }
}

public class CGlibProxy {
    public static void main(String[] args) {
        CGlibHosee cGlibHosee = new CGlibHosee();
        CGlibHoseeProxy cGlibHoseeProxy = new CGlibHoseeProxy();
        CGlibHosee proxy = (CGlibHosee) cGlibHoseeProxy.bind(cGlibHosee);
        System.out.println(proxy.sayhi());
    }
}