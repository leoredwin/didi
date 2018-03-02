/*
 * Package name:com.leo.spring
 * File name:InitHelloWorld.java
 * Date:2018-01-15 17:02
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-15 17:02
 */
public class InitHelloWorld implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization:" + beanName);
        return null;
    }
}