/*
 * Package name:com.omniprimeinc.fund.bh.services.model
 * File name:CustomerAuditModel.java
 * Date:2017-05-12 11:00
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-05-12 11:00
 */
public class CustomerAuditModel {
    private String outTradeNo;
    private String callbackUrl;
    private String trustProjectCode;
    private LoanUser loanUser;
    private LoanAccount loanAccount;

    @Override
    public String toString() {
        return  "{" +
                "\"" + "outTradeNo" + "\"" + ":" + "\"" + outTradeNo + "\"" + "," +
                "\"" + "callbackUrl" + "\"" + ":" + "\"" + callbackUrl + "\"" + "," +
                "\"" + "trustProjectCode" + "\"" + ":" + "\"" + trustProjectCode + "\"" + "," +
                "\"" + "loanUser" + "\"" + ":" + "\"" + loanUser + "\"" + "," +
                "\"" + "loanAccount" + "\"" + ":" + "\"" + loanAccount + "\"" + "," +
                '}';
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public LoanUser getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(LoanUser loanUser) {
        this.loanUser = loanUser;
    }

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

    public String getTrustProjectCode() {
        return trustProjectCode;
    }

    public void setTrustProjectCode(String trustProjectCode) {
        this.trustProjectCode = trustProjectCode;
    }
}