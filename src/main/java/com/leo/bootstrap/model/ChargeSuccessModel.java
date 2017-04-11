package com.leo.bootstrap.model;


import java.math.BigDecimal;

/**
 * Created by leo on 2016/10/11.
 */
public class ChargeSuccessModel {

    @OrderAnnotation(id = 1, name = "机构代码", require = true)
    private String orgCode;

    @OrderAnnotation(id = 2, name = "合同号", require = true)
    private String contractNo;

    @OrderAnnotation(id = 3, name = "扣款方式", require = true)
    private String chargeMethod;

    //说明：此字段用来标识该笔还款的类型，根据客户的实际还款情况标识此字段
    //备注：1、当扣款类型是01、02、时，本期状态为正常 2、当扣款类型是03时，本期状态为结清 3、当扣款类型是04（51垫付）时，本期状态为代偿 4、当扣款类型为06时，本期状态为代偿后结束 5、部分还款时，扣款类型为01，本期状态为未还清
    @OrderAnnotation(id = 4, name = "扣款类型", require = true)
    private String chargeType;
    //场景：应还100，只有98，为了提高用户体验，还98也接受
    @OrderAnnotation(id = 5, name = "减免标识", require = true)
    private String derateFlag;

    @OrderAnnotation(id = 6, name = "姓名", require = true)
    private String name;

    @OrderAnnotation(id = 7, name = "证件号", require = true)
    private String idNo;

    @OrderAnnotation(id = 8, name = "还款账号", require = true)
    private String cardId;

    //01 正常---当前期次还清 02 未还清--当前期次未还清 03 结清-（将剩余款项全部还清，适用于提前还款） 04 (履行担保)理赔 05 代偿 06 代偿结束 99 其他 注意：对于最后一个期次的还款，若客户还清，则为01正常。未还清则为02未还清
    //备注：1、04指的是把债权买断，用于其他公司，目前业务不涉及 2、05指的是51帮客户垫付，3、06指的是51帮客户垫付后，又从客户那将款项追回
    @OrderAnnotation(id = 9, name = "本期状态", require = true)
    private String currentStatus;

    @OrderAnnotation(id = 10, name = "本期期数", require = true)
    private String currentInstallmentNum;

    //为12—18的总和
    @OrderAnnotation(id = 11, name = "实扣金额", require = true)
    private BigDecimal realBuckleAmount;

    @OrderAnnotation(id = 12, name = "实扣本金", require = true)
    private BigDecimal realBucklePrincipal;

    @OrderAnnotation(id = 13, name = "实扣利息", require = true)
    private BigDecimal realBuckleInterest;

    //逾期还款使用
    @OrderAnnotation(id = 14, name = "实扣罚息", require = true)
    private BigDecimal realBucklePenaltyInsterest;

    //提前还款使用
    @OrderAnnotation(id = 15, name = "实扣违约金", require = true)
    private BigDecimal realBuckleDedit;

    @OrderAnnotation(id = 16, name = "实扣手续费", require = true)
    private BigDecimal realBuckleHandFee;

    //阳光则为保费	与申请中的担保对应，可为0
    @OrderAnnotation(id = 17, name = "实还担保费", require = true)
    private BigDecimal realBuckleGuaranteeFee;

    //与申请中的担保对应，可为0
    @OrderAnnotation(id = 18, name = "实还服务费", require = true)
    private BigDecimal realBuckleServiceFee;

    @OrderAnnotation(id = 19, name = "逾期天数", require = true)
    private String overdueDays;

    //银行实际扣款时间
    @OrderAnnotation(id = 20, name = "扣款日期（实际）", require = true)
    private String chargeDate;

    //减免金额，若减免标识字段为是，则此字段为必填
    @OrderAnnotation(id = 21, name = "费用一")
    private BigDecimal fee1;

    //网贷平台需退服务费
    @OrderAnnotation(id = 22, name = "费用二", require = true)
    private BigDecimal fee2;

    //10 是 20 否	是否超过银行限额，若为10 是，则实扣金额小于应该金额不计逾期，且第二天继续传扣款文件，若未收到，则记逾期
    @OrderAnnotation(id = 23, name = "费用三", require = true)
    private BigDecimal fee3;

    //备用，可为空
    @OrderAnnotation(id = 24, name = "费用四", require = true)
    private BigDecimal reliefPrincipalInterest;

    //备用，可为空
    @OrderAnnotation(id = 25, name = "费用五")
    private BigDecimal fee5;

    @Override
    public String toString() {
        return "ChargeSuccessModel{" +
                "orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", chargeMethod='" + chargeMethod + '\'' +
                ", chargeType='" + chargeType + '\'' +
                ", derateFlag='" + derateFlag + '\'' +
                ", name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", currentInstallmentNum='" + currentInstallmentNum + '\'' +
                ", realBuckleAmount='" + realBuckleAmount + '\'' +
                ", realBucklePrincipal='" + realBucklePrincipal + '\'' +
                ", realBuckleInterest='" + realBuckleInterest + '\'' +
                ", realBucklePenaltyInsterest='" + realBucklePenaltyInsterest + '\'' +
                ", realBuckleDedit='" + realBuckleDedit + '\'' +
                ", realBuckleHandFee='" + realBuckleHandFee + '\'' +
                ", realBuckleGuaranteeFee='" + realBuckleGuaranteeFee + '\'' +
                ", realBuckleServiceFee='" + realBuckleServiceFee + '\'' +
                ", overdueDays='" + overdueDays + '\'' +
                ", chargeDate='" + chargeDate + '\'' +
                ", fee1='" + fee1 + '\'' +
                ", fee2='" + fee2 + '\'' +
                ", fee3='" + fee3 + '\'' +
                ", reliefPrincipalInterest='" + reliefPrincipalInterest + '\'' +
                ", fee5='" + fee5 + '\'' +
                '}';
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getChargeMethod() {
        return chargeMethod;
    }

    public void setChargeMethod(String chargeMethod) {
        this.chargeMethod = chargeMethod;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getDerateFlag() {
        return derateFlag;
    }

    public void setDerateFlag(String derateFlag) {
        this.derateFlag = derateFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentInstallmentNum() {
        return currentInstallmentNum;
    }

    public void setCurrentInstallmentNum(String currentInstallmentNum) {
        this.currentInstallmentNum = currentInstallmentNum;
    }

    public BigDecimal getRealBuckleAmount() {
        return realBuckleAmount;
    }

    public void setRealBuckleAmount(BigDecimal realBuckleAmount) {
        this.realBuckleAmount = realBuckleAmount.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBucklePrincipal() {
        return realBucklePrincipal;
    }

    public void setRealBucklePrincipal(BigDecimal realBucklePrincipal) {
        this.realBucklePrincipal = realBucklePrincipal.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBuckleInterest() {
        return realBuckleInterest;
    }

    public void setRealBuckleInterest(BigDecimal realBuckleInterest) {
        this.realBuckleInterest = realBuckleInterest.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBucklePenaltyInsterest() {
        return realBucklePenaltyInsterest;
    }

    public void setRealBucklePenaltyInsterest(BigDecimal realBucklePenaltyInsterest) {
        this.realBucklePenaltyInsterest = realBucklePenaltyInsterest.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBuckleDedit() {
        return realBuckleDedit;
    }

    public void setRealBuckleDedit(BigDecimal realBuckleDedit) {
        this.realBuckleDedit = realBuckleDedit.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBuckleHandFee() {
        return realBuckleHandFee;
    }

    public void setRealBuckleHandFee(BigDecimal realBuckleHandFee) {
        this.realBuckleHandFee = realBuckleHandFee.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBuckleGuaranteeFee() {
        return realBuckleGuaranteeFee;
    }

    public void setRealBuckleGuaranteeFee(BigDecimal realBuckleGuaranteeFee) {
        this.realBuckleGuaranteeFee = realBuckleGuaranteeFee.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getRealBuckleServiceFee() {
        return realBuckleServiceFee;
    }

    public void setRealBuckleServiceFee(BigDecimal realBuckleServiceFee) {
        this.realBuckleServiceFee = realBuckleServiceFee.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public String getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(String overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getFee1() {
        return fee1;
    }

    public void setFee1(BigDecimal fee1) {
        this.fee1 = fee1.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getFee2() {
        return fee2;
    }

    public void setFee2(BigDecimal fee2) {
        this.fee2 = fee2.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getFee3() {
        return fee3;
    }

    public void setFee3(BigDecimal fee3) {
        this.fee3 = fee3.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getReliefPrincipalInterest() {
        return reliefPrincipalInterest;
    }

    public void setReliefPrincipalInterest(BigDecimal reliefPrincipalInterest) {
        this.reliefPrincipalInterest = reliefPrincipalInterest.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getFee5() {
        return fee5;
    }

    public void setFee5(BigDecimal fee5) {
        this.fee5 = fee5.setScale(2, BigDecimal.ROUND_DOWN);
    }
}
