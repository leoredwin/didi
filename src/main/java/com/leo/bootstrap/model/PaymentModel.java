package com.leo.bootstrap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by niushw on 2016/9/9.
 */
public class PaymentModel implements Serializable {

    private static final int NO_LENDING = 0;
    private static final int HAS_BEEN_LENDING = 1;
    private static final int OVERDUE = 2;
    private static final int PREPAYMMENT = 3;
    private static final int SETTLEMENT = 4;

    private String loanNo;
    private String appId;
    private String paymentFundId;
    private byte status;
    private String userId;
    private String userName;
    private String idCard;
    private String phone;
    private String bankAccount;
    private String bankName;
    private String bankCode;
    private BigDecimal amount;
    private byte repayments;
    private Date payDate;

    @Override
    public String toString() {
        return
                "{" +
                        "\"" + "loanNo" + "\"" + ":" + "\"" + loanNo + "\"" + "," +
                        "\"" + "appId" + "\"" + ":" + "\"" + appId + "\"" + "," +
                        "\"" + "paymentFundId" + "\"" + ":" + "\"" + paymentFundId + "\"" + "," +
                        "\"" + "status" + "\"" + ":" + "\"" + status + "\"" + "," +
                        "\"" + "userId" + "\"" + ":" + "\"" + userId + "\"" + "," +
                        "\"" + "userName" + "\"" + ":" + "\"" + userName + "\"" + "," +
                        "\"" + "idCard" + "\"" + ":" + "\"" + idCard + "\"" + "," +
                        "\"" + "phone" + "\"" + ":" + "\"" + phone + "\"" + "," +
                        "\"" + "bankAccount" + "\"" + ":" + "\"" + bankAccount + "\"" + "," +
                        "\"" + "bankName" + "\"" + ":" + "\"" + bankName + "\"" + "," +
                        "\"" + "bankCode" + "\"" + ":" + "\"" + bankCode + "\"" + "," +
                        "\"" + "amount" + "\"" + ":" + "\"" + amount + "\"" + "," +
                        "\"" + "repayments" + "\"" + ":" + "\"" + repayments + "\"" + "," +
                        "\"" + "payDate" + "\"" + ":" + payDate +
                        '}';
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPaymentFundId() {
        return paymentFundId;
    }

    public void setPaymentFundId(String paymentFundId) {
        this.paymentFundId = paymentFundId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public byte getRepayments() {
        return repayments;
    }

    public void setRepayments(byte repayments) {
        this.repayments = repayments;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
