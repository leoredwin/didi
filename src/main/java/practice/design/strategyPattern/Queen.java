/*
 * Package name:practice.design.strategyPattern
 * File name:Queen.java
 * Date:2017-06-08 17:05
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.strategyPattern;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:05
 */
public class Queen extends Character {

    public Queen() {
        weaponBehavior = new BowAndArrowBehavior();
    }

    @Override
    void fight() {
        System.out.println("queen is fighting");
    }
}