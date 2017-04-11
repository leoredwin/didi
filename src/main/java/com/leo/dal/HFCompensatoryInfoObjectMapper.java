package com.leo.dal;


import com.leo.dal.object.HFCompensatoryInfoObject;
import com.leo.dal.object.HFCompensatoryInfoObjectExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by niushw on 2017/1/4.
 */
public interface HFCompensatoryInfoObjectMapper extends MybatisBaseMapper<HFCompensatoryInfoObject, Integer, HFCompensatoryInfoObjectExample> {

    @Insert({
            "<script>" +
                    "            insert into hf_compensatory_info_object " +
                    "            (app_id, " +
                    "            date_due)" +
                    "        values " +
                    "            <foreach collection='list' index='index' item='record' separator=','>" +
                    "            (#{record.appId,jdbcType=CHAR}," +
                    "            #{record.dateDue,jdbcType=CHAR})" +
                    "            </foreach>" +
                    "           </script>"
    })
    int insertBatch(@Param("list") List<HFCompensatoryInfoObject> list);
}
