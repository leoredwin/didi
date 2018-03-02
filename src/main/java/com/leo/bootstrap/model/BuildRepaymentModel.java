/*
 * Package name:com.omniprimeinc.fund.charge.api.models
 * File name:BuildRepaymentModel.java
 * Date:2017-07-04 18:36
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

import java.math.BigDecimal;

/**
 * Desc生成砍头息还款计划表的入参pojo类
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-07-04 18:36
 */
public class BuildRepaymentModel {

    private String appId;//申请id
    private String productId;//金融产品id
    private String fundId;//资金源id
    private BigDecimal principal;//本金
    private int repayments;//借款总期数

    @Override
    public String toString() {
        return "{" +
                "\"" + "appId" + "\"" + ":" + "\"" + appId + "\"" + "," +
                "\"" + "productId" + "\"" + ":" + "\"" + productId + "\"" + "," +
                "\"" + "fundId" + "\"" + ":" + "\"" + fundId + "\"" + "," +
                "\"" + "principal" + "\"" + ":" + principal + "," +
                "\"" + "repayments" + "\"" + ":" + repayments +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public int getRepayments() {
        return repayments;
    }

    public void setRepayments(int repayments) {
        this.repayments = repayments;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}