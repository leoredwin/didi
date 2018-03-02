/*
 * Package name:com.leo.bootstrap.model
 * File name:MyModel.java
 * Date:2017-07-18 22:05
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-07-18 22:05
 */
public class MyModel {
    private String appId;
    private String userId;
    private String operatorId;
    private Long date;
    private int chargeType;

    @Override
    public String toString() {
        return
                "{" +
                        "\"" + "appId" + "\"" + ":" + "\"" + appId + "\"" + "," +
                        "\"" + "userId" + "\"" + ":" + "\"" + userId + "\"" + "," +
                        "\"" + "operatorId" + "\"" + ":" + "\"" + operatorId + "\"" + "," +
                        "\"" + "date" + "\"" + ":" + "\"" + date + "\"" + "," +
                        "\"" + "chargeType" + "\"" + ":" + chargeType +
                        '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }
}