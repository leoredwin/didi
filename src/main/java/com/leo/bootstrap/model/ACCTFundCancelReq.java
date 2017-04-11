package com.leo.bootstrap.model;

/**
 * Created by niushw on 2017/2/10.
 */
public class ACCTFundCancelReq {

    private String originRequestId;

    private String signature;

    private String accessor;

    private String requestId;

    private String oprId;
    private String oprName;
    private String busiCode;
    private String extension;
    private String memo;

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAccessor() {
        return this.accessor;
    }

    public void setAccessor(String accessor) {
        this.accessor = accessor;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOprId() {
        return this.oprId;
    }

    public void setOprId(String oprId) {
        this.oprId = oprId;
    }

    public String getOprName() {
        return this.oprName;
    }

    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getBusiCode() {
        return this.busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public ACCTFundCancelReq() {
    }

    public String getOriginRequestId() {
        return this.originRequestId;
    }

    public void setOriginRequestId(String originRequestId) {
        this.originRequestId = originRequestId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"" + "originRequestId" + "\"" + ":" + "\"" + originRequestId + "\"" + "," +
                "\"" + "signature" + "\"" + ":" + "\"" + signature + "\"" + "," +
                "\"" + "accessor" + "\"" + ":" + "\"" + accessor + "\"" + "," +
                "\"" + "requestId" + "\"" + ":" + "\"" + requestId + "\"" + "," +
                "\"" + "oprId" + "\"" + ":" + "\"" + oprId + "\"" + "," +
                "\"" + "oprName" + "\"" + ":" + "\"" + oprName + "\"" + "," +
                "\"" + "busiCode" + "\"" + ":" + "\"" + busiCode + "\"" + "," +
                "\"" + "extension" + "\"" + ":" + "\"" + extension + "\"" + "," +
                "\"" + "memo" + "\"" + ":" + memo +
                '}';
    }
}
