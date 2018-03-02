package com.leo.dal;

import com.leo.dal.object.BHLoanObject;
import com.leo.dal.object.BHLoanObjectExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-07-11 14:45
 */
public interface BHLoanObjectMapper extends MybatisBaseMapper<BHLoanObject, Integer, BHLoanObjectExample> {
    @Insert({
            "<script>" +
                    "            insert into bh_loan_object (app_id, payment_fund_id, status,\n" +
                    "            user_id, user_name, id_card,\n" +
                    "            phone, bank_account, bank_name,\n" +
                    "            bank_code, amount, repayments,\n" +
                    "            pay_date, check_date, pay_dead_date,\n" +
                    "            is_send, application_site, living_address,\n" +
                    "            marriage_status, education, product_type_name,\n" +
                    "            create_time, update_time, update_by\n" +
                    "    )" +
                    "        values " +
                    "            <foreach collection='list' index='index' item='record' separator=','>" +
                    "            (#{record.appId,jdbcType=CHAR}," +
                    "            #{record.paymentFundId,jdbcType=CHAR}," +
                    "            #{record.status,jdbcType=TINYINT}," +
                    "            #{record.userId,jdbcType=CHAR}," +
                    "            #{record.userName,jdbcType=VARCHAR}," +
                    "            #{record.idCard,jdbcType=CHAR}," +
                    "            #{record.phone,jdbcType=CHAR}," +
                    "            #{record.bankAccount,jdbcType=CHAR}," +
                    "            #{record.bankName,jdbcType=VARCHAR}," +
                    "            #{record.bankCode,jdbcType=CHAR}," +
                    "            #{record.amount,jdbcType=DECIMAL}," +
                    "            #{record.repayments,jdbcType=TINYINT}," +
                    "            #{record.payDate,jdbcType=TIMESTAMP}," +
                    "            #{record.checkDate,jdbcType=TIMESTAMP}," +
                    "            #{record.payDeadDate,jdbcType=DATE}," +
                    "            #{record.isSend,jdbcType=TINYINT}," +
                    "            #{record.applicationSite,jdbcType=VARCHAR}," +
                    "            #{record.livingAddress,jdbcType=VARCHAR}," +
                    "            #{record.marriageStatus,jdbcType=TINYINT}," +
                    "            #{record.education,jdbcType=TINYINT}," +
                    "            #{record.productTypeName,jdbcType=VARCHAR}," +
                    "            #{record.createTime,jdbcType=TIMESTAMP}," +
                    "            #{record.updateTime,jdbcType=TIMESTAMP}," +
                    "            #{record.updateBy,jdbcType=VARCHAR})" +
                    "            </foreach>" +
                    "           </script>"

    })
    int insertBatch(@Param("list") List<BHLoanObject> list);

    @Select({
            "select * from bh_loan_object"
    })
    List<BHLoanObject> getAll();
}
