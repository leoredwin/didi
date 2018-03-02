/*
 * Package name:practice.design.strategyPattern
 * File name:Character.java
 * Date:2017-06-08 17:00
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.strategyPattern;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:00
 */
public abstract class Character {

    WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    abstract void fight();
}