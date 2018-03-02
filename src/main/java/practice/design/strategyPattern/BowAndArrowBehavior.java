/*
 * Package name:practice.design.strategyPattern
 * File name:BewAndArrowBehavior.java
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
public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("use bow and arrow weapon");
    }
}