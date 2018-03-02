/*
 * Package name:practice.design.decorate
 * File name:StarbuzzCoffee.java
 * Date:2017-06-09 12:26
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.decorate;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-09 12:26
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription() + "$" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + "$" + beverage1.cost());
    }
}