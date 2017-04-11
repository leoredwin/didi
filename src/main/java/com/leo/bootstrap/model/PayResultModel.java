package com.leo.bootstrap.model;

/**
 * Created by leo on 2016/10/11.
 */
public class PayResultModel {

    @OrderAnnotation(id = 1, name = "机构代码", require = true)
    private String orgCode;

    @OrderAnnotation(id = 2, name = "合同号", require = true)
    private String contractNo;

    //30 放款成功 40 放款失败
    @OrderAnnotation(id = 3, name = "放款结果")
    private String payResult;

    //yyyyMMddhh24mmss 如果是通过第三方支付渠道放款的，该字段是有值的；否则该字段可以为空
    @OrderAnnotation(id = 4, name = "银行回盘时间")
    private String bankCallbackTime;

    //如果是通过第三方支付渠道放款的，该字段是有值得；否则改制可以为空
    @OrderAnnotation(id = 5, name = "失败原因")
    private String failReason;

    //01审批通过 02审批拒绝 优先判断，审批通过才有放款结果的状态
    @OrderAnnotation(id = 6, name = "审批结果", require = true)
    private String approvalResult;

    //如果审批拒绝，该字段有值；否则该字段为空
    @OrderAnnotation(id = 7, name = "审批拒绝原因")
    private String approvalFailReason;

    @Override
    public String toString() {
        return "PayResultModel{" +
                "orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", payResult='" + payResult + '\'' +
                ", bankCallbackTime='" + bankCallbackTime + '\'' +
                ", failReason='" + failReason + '\'' +
                ", approvalResult='" + approvalResult + '\'' +
                ", approvalFailReason='" + approvalFailReason + '\'' +
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

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getBankCallbackTime() {
        return bankCallbackTime;
    }

    public void setBankCallbackTime(String bankCallbackTime) {
        this.bankCallbackTime = bankCallbackTime;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getApprovalFailReason() {
        return approvalFailReason;
    }

    public void setApprovalFailReason(String approvalFailReason) {
        this.approvalFailReason = approvalFailReason;
    }
}
