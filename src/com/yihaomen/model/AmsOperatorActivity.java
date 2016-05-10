package com.yihaomen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AmsOperatorActivity implements Serializable {
    //主键
    private String id;

    //活动ID
    private String activityId;

    //中文描述
    private String activityDesc;

    //操盘手
    private String operator;

    //是否停用(0 否  1 是)
    private Boolean isDown;

    //活动成本 例如：打车、买水、记者红包等等
    private BigDecimal activityCost;

    //活动成本备注
    private String activityRemark;

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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc == null ? null : activityDesc.trim();
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

    public BigDecimal getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(BigDecimal activityCost) {
        this.activityCost = activityCost;
    }

    public String getActivityRemark() {
        return activityRemark;
    }

    public void setActivityRemark(String activityRemark) {
        this.activityRemark = activityRemark == null ? null : activityRemark.trim();
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