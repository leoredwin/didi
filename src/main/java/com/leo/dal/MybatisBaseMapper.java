/**
 * Copyright (C), 上海秦苍信息科技有限公司
 */
package com.leo.dal;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Chongyuan.Yuan
 * @version $Id: MybatisBaseMapper.java, v 0.1 2016-05-31 下午5:35
 */
public interface MybatisBaseMapper<T, P, E> {

    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(P id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(P id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
