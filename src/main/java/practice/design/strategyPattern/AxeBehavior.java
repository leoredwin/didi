/*
 * Package name:practice.design.strategyPattern
 * File name:AxeBehavior.java
 * Date:2017-06-08 17:04
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.strategyPattern;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:04
 */
public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("use axe weapon");
    }
}