package com.leo.bootstrap.model;

/**
 * Created by niushw on 2017/1/16.
 */
public class RepaymentRequest {

    private String appId;
    private String userId;
    private String operatorId;
    private long date;

    private int chargeType; // 30 线下 20 daishou 10 manual

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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        return "{" +
                "appId='" + appId + '\'' +
                ", userId='" + userId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", date=" + date +
                ", chargeType=" + chargeType +
                '}';
    }
}
