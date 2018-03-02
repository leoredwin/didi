/*
 * Package name:practice.design.strategyPattern
 * File name:Country.java
 * Date:2017-06-08 17:07
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.strategyPattern;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:07
 */
public class Country {

    public static void main(String[] args){
        Character king = new King();
        king.fight();
        king.weaponBehavior.useWeapon();
        king.setWeaponBehavior(new KnifeBehavior());
        king.weaponBehavior.useWeapon();
    }
}