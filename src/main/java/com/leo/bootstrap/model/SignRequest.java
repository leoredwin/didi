package com.leo.bootstrap.model;

/**
 * Created by dingyc on 2016/6/15.
 */
public class SignRequest {
    private String userId;
    private String accessor;
    private String channelCode;
    private String idName;
    private String idCard;
    private String phone;
    private String bankAccount;
    private String bankName;
    private String bankCode;
    private String memo;
    private String extensionInfo;
    private String operatorId;
    private String fundId;        //增加fundId

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccessor() {
        return accessor;
    }

    public void setAccessor(String accessor) {
        this.accessor = accessor;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExtensionInfo() {
        return extensionInfo;
    }

    public void setExtensionInfo(String extensionInfo) {
        this.extensionInfo = extensionInfo;
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

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Override
    public String toString() {
        return

                "{" +
                        "\"" + "userId" + "\"" + ":" + "\"" + userId + "\"" + "," +
                        "\"" + "accessor" + "\"" + ":" + "\"" + accessor + "\"" + "," +
                        "\"" + "channelCode" + "\"" + ":" + "\"" + channelCode + "\"" + "," +
                        "\"" + "idName" + "\"" + ":" + "\"" + idName + "\"" + "," +
                        "\"" + "idCard" + "\"" + ":" + "\"" + idCard + "\"" + "," +
                        "\"" + "phone" + "\"" + ":" + "\"" + phone + "\"" + "," +
                        "\"" + "bankAccount" + "\"" + ":" + "\"" + bankAccount + "\"" + "," +
                        "\"" + "bankName" + "\"" + ":" + "\"" + bankName + "\"" + "," +
                        "\"" + "bankCode" + "\"" + ":" + "\"" + bankCode + "\"" + "," +
                        "\"" + "memo" + "\"" + ":" + "\"" + memo + "\"" + "," +
                        "\"" + "extensionInfo" + "\"" + ":" + "\"" + extensionInfo + "\"" + "," +
                        "\"" + "operatorId" + "\"" + ":" + "\"" + operatorId + "\"" + "," +
                        "\"" + "fundId" + "\"" + ":" + fundId +
                        '}';
    }
}
