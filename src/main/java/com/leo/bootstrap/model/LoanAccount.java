/*
 * Package name:com.omniprimeinc.fund.bh.services.model
 * File name:PutoutAccount.java
 * Date:2017-05-12 11:03
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-05-12 11:03
 */
public class LoanAccount {
    private String putoutAccountType;
    private String putoutBankCode;
    private String putoutAccountName;
    private String putoutAccountNo;
    private String putoutAccountBank;
    private String putoutAccountProvince;
    private String putoutAccountCity;

    @Override
    public String toString() {
        return "{" +
                "\"" + "putoutAccountType" + "\"" + ":" + "\"" + putoutAccountType + "\"" + "," +
                "\"" + "putoutBankCode" + "\"" + ":" + "\"" + putoutBankCode + "\"" + "," +
                "\"" + "putoutAccountName" + "\"" + ":" + "\"" + putoutAccountName + "\"" + "," +
                "\"" + "putoutAccountNo" + "\"" + ":" + "\"" + putoutAccountNo + "\"" + "," +
                "\"" + "putoutAccountBank" + "\"" + ":" + "\"" + putoutAccountBank + "\"" + "," +
                "\"" + "putoutAccountProvince" + "\"" + ":" + "\"" + putoutAccountProvince + "\"" + "," +
                "\"" + "putoutAccountCity" + "\"" + ":" + "\"" + putoutAccountCity + "\"" +
                '}';
    }

    public String getPutoutAccountType() {
        return putoutAccountType;
    }

    public void setPutoutAccountType(String putoutAccountType) {
        this.putoutAccountType = putoutAccountType;
    }

    public String getPutoutBankCode() {
        return putoutBankCode;
    }

    public void setPutoutBankCode(String putoutBankCode) {
        this.putoutBankCode = putoutBankCode;
    }

    public String getPutoutAccountName() {
        return putoutAccountName;
    }

    public void setPutoutAccountName(String putoutAccountName) {
        this.putoutAccountName = putoutAccountName;
    }

    public String getPutoutAccountNo() {
        return putoutAccountNo;
    }

    public void setPutoutAccountNo(String putoutAccountNo) {
        this.putoutAccountNo = putoutAccountNo;
    }

    public String getPutoutAccountBank() {
        return putoutAccountBank;
    }

    public void setPutoutAccountBank(String putoutAccountBank) {
        this.putoutAccountBank = putoutAccountBank;
    }

    public String getPutoutAccountProvince() {
        return putoutAccountProvince;
    }

    public void setPutoutAccountProvince(String putoutAccountProvince) {
        this.putoutAccountProvince = putoutAccountProvince;
    }

    public String getPutoutAccountCity() {
        return putoutAccountCity;
    }

    public void setPutoutAccountCity(String putoutAccountCity) {
        this.putoutAccountCity = putoutAccountCity;
    }
}