package com.yihaomen.inter;

import com.yihaomen.model.AmsOperatorOriginality;
import com.yihaomen.model.AmsOperatorOriginalityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsOperatorOriginalityMapper {
    int countByCriteria(AmsOperatorOriginalityCriteria example);

    int deleteByCriteria(AmsOperatorOriginalityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(AmsOperatorOriginality record);

    int insertSelective(AmsOperatorOriginality record);

    List<AmsOperatorOriginality> selectByCriteria(AmsOperatorOriginalityCriteria example);

    AmsOperatorOriginality selectByPrimaryKey(String id);

    int updateByCriteriaSelective(@Param("record") AmsOperatorOriginality record, @Param("example") AmsOperatorOriginalityCriteria example);

    int updateByExample(@Param("record") AmsOperatorOriginality record, @Param("example") AmsOperatorOriginalityCriteria example);

    int updateByPrimaryKeySelective(AmsOperatorOriginality record);

    int updateByPrimaryKey(AmsOperatorOriginality record);
}