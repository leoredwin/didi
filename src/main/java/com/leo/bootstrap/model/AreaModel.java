/*
 * Package name:com.leo.bootstrap.model
 * File name:SitModel.java
 * Date:2017-06-21 16:32
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-21 16:32
 */
public class AreaModel {
    private LocalModel area;
    private LocalModel province;
    private LocalModel city;

    public LocalModel getArea() {
        return area;
    }

    public void setArea(LocalModel area) {
        this.area = area;
    }

    public LocalModel getProvince() {
        return province;
    }

    public void setProvince(LocalModel province) {
        this.province = province;
    }

    public LocalModel getCity() {
        return city;
    }

    public void setCity(LocalModel city) {
        this.city = city;
    }
}