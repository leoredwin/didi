/*
 * Package name:practice.design.proxy
 * File name:TestCGlibProxy.java
 * Date:2018-01-24 17:44
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
 * @since 2018-01-24 17:44
 */
public class TestCGlibProxy {
    public static void main(String[] args) {
        TestCGlib testCGlib = new TestCGlib();
        TestCGlibProxyImpl testCGlibProxy = new TestCGlibProxyImpl();
        TestCGlib proxy = (TestCGlib) testCGlibProxy.bind(testCGlib);
        System.out.println(proxy.sayhi());
    }
}

class TestCGlib {
    public String sayhi() {
        return "im testCGlib";
    }
}

class TestCGlibProxyImpl {
    Object object;

    public Object bind(final Object target) {
        this.object = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("im proxy!");
                return method.invoke(target, objects);
            }
        });
        return enhancer.create();
    }
}