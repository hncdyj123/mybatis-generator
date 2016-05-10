package com.yihaomen.inter;

import com.yihaomen.model.AmsOperatorActivity;
import com.yihaomen.model.AmsOperatorActivityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsOperatorActivityMapper {
    int countByCriteria(AmsOperatorActivityCriteria example);

    int deleteByCriteria(AmsOperatorActivityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(AmsOperatorActivity record);

    int insertSelective(AmsOperatorActivity record);

    List<AmsOperatorActivity> selectByCriteria(AmsOperatorActivityCriteria example);

    AmsOperatorActivity selectByPrimaryKey(String id);

    int updateByCriteriaSelective(@Param("record") AmsOperatorActivity record, @Param("example") AmsOperatorActivityCriteria example);

    int updateByExample(@Param("record") AmsOperatorActivity record, @Param("example") AmsOperatorActivityCriteria example);

    int updateByPrimaryKeySelective(AmsOperatorActivity record);

    int updateByPrimaryKey(AmsOperatorActivity record);
}