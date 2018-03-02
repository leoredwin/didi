/*
 * Package name:practice.design.decorate
 * File name:Mocha.java
 * Date:2017-06-09 12:24
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.decorate;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-09 12:24
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}