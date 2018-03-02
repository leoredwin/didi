/*
 * Package name:com.leo.bootstrap.model
 * File name:TopModel.java
 * Date:2017-06-21 16:35
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

import java.math.BigDecimal;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-21 16:35
 */
public class TopModel {

    private AreaModel areaMap;

    private BigDecimal frontInterest;

    public AreaModel getAreaMap() {
        return areaMap;
    }

    public void setAreaMap(AreaModel areaMap) {
        this.areaMap = areaMap;
    }

    public BigDecimal getFrontInterest() {
        return frontInterest;
    }

    public void setFrontInterest(BigDecimal frontInterest) {
        this.frontInterest = frontInterest;
    }
}