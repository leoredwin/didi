package com.leo.bootstrap.model;

/**
 * Created by zhoukb on 2016/9/13.
 */
public class ModelUtil {

    public static void copyProperties(PaymentModel toFundPaymentModel, PaymentRequest fromTransPaymentRequest) {
        if (fromTransPaymentRequest == null) {
            toFundPaymentModel = null;
            return;
        }

        if (toFundPaymentModel == null) {
            toFundPaymentModel = new PaymentModel();
        }

        toFundPaymentModel.setAppId(fromTransPaymentRequest.getAppId());
        toFundPaymentModel.setPaymentFundId(fromTransPaymentRequest.getFundSource());
        toFundPaymentModel.setUserId(fromTransPaymentRequest.getUserId());
        toFundPaymentModel.setUserName(fromTransPaymentRequest.getUserName());
        toFundPaymentModel.setIdCard(fromTransPaymentRequest.getIdCard());
        toFundPaymentModel.setPhone(fromTransPaymentRequest.getPhone());
        toFundPaymentModel.setBankAccount(fromTransPaymentRequest.getBankAccount());
        toFundPaymentModel.setBankName(fromTransPaymentRequest.getBankName());
        toFundPaymentModel.setBankCode(fromTransPaymentRequest.getBankCode());
        toFundPaymentModel.setAmount(fromTransPaymentRequest.getAmount());
        toFundPaymentModel.setRepayments(fromTransPaymentRequest.getRepayments().byteValue());
        toFundPaymentModel.setPayDate(fromTransPaymentRequest.getPayDate());
    }

}
