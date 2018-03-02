/*
 * Package name:practice.design.factory
 * File name:Pizza.java
 * Date:2017-08-07 17:48
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.factory;

import java.util.ArrayList;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-08-07 17:48
 */
public abstract class Pizza {

    String name;
    String dough;
    String sauce;

    ArrayList toppings = new ArrayList();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        toppings.stream().forEach(topping -> {
            System.out.println("  " + topping);
        });
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}