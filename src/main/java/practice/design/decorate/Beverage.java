/*
 * Package name:practice.design.decorate
 * File name:Beverage.java
 * Date:2017-06-09 12:20
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.decorate;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-09 12:20
 */
public abstract class Beverage {
    String description = "Unknown Beverage ";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}