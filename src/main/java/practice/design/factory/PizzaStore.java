/*
 * Package name:practice.design.factory
 * File name:PizzaStore.java
 * Date:2017-08-07 17:35
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.factory;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-08-07 17:35
 */
public abstract class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = factory.createPizza(type);
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}