package com.yihaomen.model;

import java.io.Serializable;
import java.util.Date;

public class AmsOperatorOriginality implements Serializable {
    //主键
    private String id;

    //创意ID
    private String originalityId;

    //中文描述
    private String originalityDesc;

    //看板标识
    private Boolean paintFlag;

    //操盘手
    private String operator;

    //是否停用(0 否  1 是)
    private Boolean isDown;

    //创建人
    private String createName;

    //创建时间
    private Date createDatetime;

    //修改人
    private String updateName;

    //修改时间
    private Date updateDatetime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOriginalityId() {
        return originalityId;
    }

    public void setOriginalityId(String originalityId) {
        this.originalityId = originalityId == null ? null : originalityId.trim();
    }

    public String getOriginalityDesc() {
        return originalityDesc;
    }

    public void setOriginalityDesc(String originalityDesc) {
        this.originalityDesc = originalityDesc == null ? null : originalityDesc.trim();
    }

    public Boolean getPaintFlag() {
        return paintFlag;
    }

    public void setPaintFlag(Boolean paintFlag) {
        this.paintFlag = paintFlag;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Boolean getIsDown() {
        return isDown;
    }

    public void setIsDown(Boolean isDown) {
        this.isDown = isDown;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}