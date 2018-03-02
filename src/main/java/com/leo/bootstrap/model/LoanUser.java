/*
 * Package name:com.omniprimeinc.fund.bh.services.model
 * File name:LoanUser.java
 * Date:2017-05-12 11:02
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

import java.math.BigDecimal;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-05-12 11:02
 */
public class LoanUser {
    private String customerName;
    private String certType = "0";
    private String certId;
    private String handPhone;
    private String phone;
    private String postalZip;
    private String commAdd;
    private String email;
    private String marriage;
    private String eduexperience;
    private String nativePlace;
    private String nativePlaceAdd;
    private BigDecimal selfMonthIncome;
    private String familyAdd;
    private String familyZip;
    private String familyTel;
    private String peroccupation;
    private String workCorp;
    private String unitKind;
    private String workAdd;
    private String workZip;
    private String workBeginDate;
    private String occupation;
    private String position;
    private BigDecimal userNetAssets;
    private BigDecimal userHouseValue;
    private BigDecimal userHouseArea;
    private String realEstateType;
    private String remark1;
    private String remark2;
    private String remark3;

    @Override
    public String toString() {
        return "{" +
                "\"" + "customerName" + "\"" + ":" + "\"" + customerName + "\"" + "," +
                "\"" + "certType" + "\"" + ":" + "\"" + certType + "\"" + "," +
                "\"" + "certId" + "\"" + ":" + "\"" + certId + "\"" + "," +
                "\"" + "handPhone" + "\"" + ":" + "\"" + handPhone + "\"" + "," +
                "\"" + "phone" + "\"" + ":" + "\"" + phone + "\"" + "," +
                "\"" + "postalZip" + "\"" + ":" + "\"" + postalZip + "\"" + "," +
                "\"" + "commAdd" + "\"" + ":" + "\"" + commAdd + "\"" + "," +
                "\"" + "email" + "\"" + ":" + "\"" + email + "\"" + "," +
                "\"" + "marriage" + "\"" + ":" + "\"" + marriage + "\"" + "," +
                "\"" + "eduexperience" + "\"" + ":" + "\"" + eduexperience + "\"" + "," +
                "\"" + "nativePlace" + "\"" + ":" + "\"" + nativePlace + "\"" + "," +
                "\"" + "nativePlaceAdd" + "\"" + ":" + "\"" + nativePlaceAdd + "\"" + "," +
                "\"" + "selfMonthIncome" + "\"" + ":" + "\"" + selfMonthIncome + "\"" + "," +
                "\"" + "familyAdd" + "\"" + ":" + "\"" + familyAdd + "\"" + "," +
                "\"" + "familyZip" + "\"" + ":" + "\"" + familyZip + "\"" + "," +
                "\"" + "familyTel" + "\"" + ":" + "\"" + familyTel + "\"" + "," +
                "\"" + "peroccupation" + "\"" + ":" + "\"" + peroccupation + "\"" + "," +
                "\"" + "workCorp" + "\"" + ":" + "\"" + workCorp + "\"" + "," +
                "\"" + "unitKind" + "\"" + ":" + "\"" + unitKind + "\"" + "," +
                "\"" + "workAdd" + "\"" + ":" + "\"" + workAdd + "\"" + "," +
                "\"" + "workZip" + "\"" + ":" + "\"" + workZip + "\"" + "," +
                "\"" + "workBeginDate" + "\"" + ":" + "\"" + workBeginDate + "\"" + "," +
                "\"" + "occupation" + "\"" + ":" + "\"" + occupation + "\"" + "," +
                "\"" + "position" + "\"" + ":" + "\"" + position + "\"" + "," +
                "\"" + "userNetAssets" + "\"" + ":" + "\"" + userNetAssets + "\"" + "," +
                "\"" + "userHouseValue" + "\"" + ":" + "\"" + userHouseValue + "\"" + "," +
                "\"" + "userHouseArea" + "\"" + ":" + "\"" + userHouseArea + "\"" + "," +
                "\"" + "realEstateType" + "\"" + ":" + "\"" + realEstateType + "\"" + "," +
                "\"" + "userNetAssets" + "\"" + ":" + "\"" + userNetAssets + "\"" + "," +
                "\"" + "remark1" + "\"" + ":" + "\"" + remark1 + "\"" + "," +
                "\"" + "remark2" + "\"" + ":" + "\"" + remark2 + "\"" + "," +
                "\"" + "remark3" + "\"" + ":" + remark3 +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getHandPhone() {
        return handPhone;
    }

    public void setHandPhone(String handPhone) {
        this.handPhone = handPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getCommAdd() {
        return commAdd;
    }

    public void setCommAdd(String commAdd) {
        this.commAdd = commAdd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEduexperience() {
        return eduexperience;
    }

    public void setEduexperience(String eduexperience) {
        this.eduexperience = eduexperience;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlaceAdd() {
        return nativePlaceAdd;
    }

    public void setNativePlaceAdd(String nativePlaceAdd) {
        this.nativePlaceAdd = nativePlaceAdd;
    }

    public BigDecimal getSelfMonthIncome() {
        return selfMonthIncome;
    }

    public void setSelfMonthIncome(BigDecimal selfMonthIncome) {
        this.selfMonthIncome = selfMonthIncome;
    }

    public String getFamilyAdd() {
        return familyAdd;
    }

    public void setFamilyAdd(String familyAdd) {
        this.familyAdd = familyAdd;
    }

    public String getFamilyZip() {
        return familyZip;
    }

    public void setFamilyZip(String familyZip) {
        this.familyZip = familyZip;
    }

    public String getFamilyTel() {
        return familyTel;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel;
    }

    public String getPeroccupation() {
        return peroccupation;
    }

    public void setPeroccupation(String peroccupation) {
        this.peroccupation = peroccupation;
    }

    public String getWorkCorp() {
        return workCorp;
    }

    public void setWorkCorp(String workCorp) {
        this.workCorp = workCorp;
    }

    public String getUnitKind() {
        return unitKind;
    }

    public void setUnitKind(String unitKind) {
        this.unitKind = unitKind;
    }

    public String getWorkAdd() {
        return workAdd;
    }

    public void setWorkAdd(String workAdd) {
        this.workAdd = workAdd;
    }

    public String getWorkZip() {
        return workZip;
    }

    public void setWorkZip(String workZip) {
        this.workZip = workZip;
    }

    public String getWorkBeginDate() {
        return workBeginDate;
    }

    public void setWorkBeginDate(String workBeginDate) {
        this.workBeginDate = workBeginDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getUserNetAssets() {
        return userNetAssets;
    }

    public void setUserNetAssets(BigDecimal userNetAssets) {
        this.userNetAssets = userNetAssets;
    }

    public BigDecimal getUserHouseValue() {
        return userHouseValue;
    }

    public void setUserHouseValue(BigDecimal userHouseValue) {
        this.userHouseValue = userHouseValue;
    }

    public BigDecimal getUserHouseArea() {
        return userHouseArea;
    }

    public void setUserHouseArea(BigDecimal userHouseArea) {
        this.userHouseArea = userHouseArea;
    }

    public String getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(String realEstateType) {
        this.realEstateType = realEstateType;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
}