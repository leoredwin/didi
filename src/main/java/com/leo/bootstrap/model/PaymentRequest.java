package com.leo.bootstrap.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 接收来自产品线的放款请求
 *
 * Created by zhoukb on 2016/9/1.
 */
public class PaymentRequest {

    private String appId;//申请id
    private String userId;//用户id
    private Integer appType;    //10: "POS"， 20："CL"
    private String fundSource;    // 产品线查询
    private BigDecimal amount;//放款金额
    private Integer repayments;//借款期数
    private String operator;//操作人（和人工放款有关）
    private Date firstPaybackDate;    //产品线自己放款的需要填
    private String userName;//用户姓名
    private String idCard;//身份证号
    private String phone;//手机号
    private String bankAccount;//银行卡号
    private String bankName;//开户行
    private String bankCode;//银行代码-如：ICBC
    private String extensionInfo;//扩展字段
    private Boolean paySuccess;    // 产品线自己放款、生成还款计划表，填true，其他填false
    private String payType;    //放款类型; 0: 自动放款, 1:人工放款，2：产品线自己放款
    private String accessor;    //业务方代码，POS:POS, CL:CL, 医美：COSMETIC,直销：PDL
    private Date payDate;    //放款时间戳， 产品线自己放款时填写
    private String productId;    // 金融产品ID，目前只在恒丰放款使用

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

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getRepayments() {
        return repayments;
    }

    public void setRepayments(Integer repayments) {
        this.repayments = repayments;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getFirstPaybackDate() {
        return firstPaybackDate;
    }

    public void setFirstPaybackDate(Date firstPaybackDate) {
        this.firstPaybackDate = firstPaybackDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getExtensionInfo() {
        return extensionInfo;
    }

    public void setExtensionInfo(String extensionInfo) {
        this.extensionInfo = extensionInfo;
    }

    public Boolean getPaySuccess() {
        return paySuccess;
    }

    public void setPaySuccess(Boolean paySuccess) {
        this.paySuccess = paySuccess;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAccessor() {
        return accessor;
    }

    public void setAccessor(String accessor) {
        this.accessor = accessor;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "appId='" + appId + '\'' +
                ", userId='" + userId + '\'' +
                ", appType=" + appType +
                ", fundSource='" + fundSource + '\'' +
                ", amount=" + amount +
                ", repayments=" + repayments +
                ", operator='" + operator + '\'' +
                ", firstPaybackDate=" + firstPaybackDate +
                ", userName='" + userName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", extensionInfo='" + extensionInfo + '\'' +
                ", paySuccess=" + paySuccess +
                ", payType='" + payType + '\'' +
                ", accessor='" + accessor + '\'' +
                ", payDate=" + payDate +
                ", productId='" + productId + '\'' +
                '}';
    }
}
