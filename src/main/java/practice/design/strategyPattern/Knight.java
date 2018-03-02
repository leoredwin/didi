/*
 * Package name:practice.design.strategyPattern
 * File name:Knight.java
 * Date:2017-06-08 17:06
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.strategyPattern;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:06
 */
public class Knight extends Character {

    public Knight() {
        weaponBehavior = new AxeBehavior();
    }

    @Override
    void fight() {
        System.out.println("knight is fighting!");
    }
}