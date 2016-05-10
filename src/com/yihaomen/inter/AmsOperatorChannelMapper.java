package com.yihaomen.inter;

import com.yihaomen.model.AmsOperatorChannel;
import com.yihaomen.model.AmsOperatorChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsOperatorChannelMapper {
    int countByCriteria(AmsOperatorChannelCriteria example);

    int deleteByCriteria(AmsOperatorChannelCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(AmsOperatorChannel record);

    int insertSelective(AmsOperatorChannel record);

    List<AmsOperatorChannel> selectByCriteria(AmsOperatorChannelCriteria example);

    AmsOperatorChannel selectByPrimaryKey(String id);

    int updateByCriteriaSelective(@Param("record") AmsOperatorChannel record, @Param("example") AmsOperatorChannelCriteria example);

    int updateByExample(@Param("record") AmsOperatorChannel record, @Param("example") AmsOperatorChannelCriteria example);

    int updateByPrimaryKeySelective(AmsOperatorChannel record);

    int updateByPrimaryKey(AmsOperatorChannel record);
}