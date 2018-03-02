/*
 * Package name:com.leo.bootstrap.model
 * File name:SiteModel.java
 * Date:2017-07-11 15:04
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-07-11 15:04
 */
public class SiteModel {
    private String appId;
    private String site;

    @Override
    public String toString() {
        return "SiteModel{" +
                "appId='" + appId + '\'' +
                ", site='" + site + '\'' +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}