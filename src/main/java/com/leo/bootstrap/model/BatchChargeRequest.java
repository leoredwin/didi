package com.leo.bootstrap.model;

/**
 * Created by niushw on 2017/1/16.
 */
public class BatchChargeRequest {
    private String appId;
    private String userId;
    private String fundId;
    private String memo;
    private String operator;
    private int appType;

    @Override
    public String toString() {
        return "{" +
                "\"" + "appId" + "\"" + ":" + "\"" + appId + "\"" + "," +
                "\"" + "userId" + "\"" + ":" + "\"" + userId + "\"" + "," +
                "\"" + "fundId" + "\"" + ":" + "\"" + fundId + "\"" + "," +
                "\"" + "memo" + "\"" + ":" + "\"" + memo + "\"" + "," +
                "\"" + "operator" + "\"" + ":" + "\"" + operator + "\"" + "," +
                "\"" + "appType" + "\"" + ":" + appType +
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

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }
}
