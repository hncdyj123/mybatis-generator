package com.yihaomen.model;

import java.io.Serializable;
import java.util.Date;

public class AmsOperatorChannel implements Serializable {
    //主键
    private String id;

    //渠道ID
    private String channelId;

    //中文描述
    private String chineseDesc;

    //渠道商ID
    private String supplierId;

    //渠道分组名
    private String groupName;

    //弃包标识(0  不弃包  1 弃包)
    private Boolean throwFlag;

    //看板标识(0 不可看 1 可看)
    private Boolean paintFlag;

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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getChineseDesc() {
        return chineseDesc;
    }

    public void setChineseDesc(String chineseDesc) {
        this.chineseDesc = chineseDesc == null ? null : chineseDesc.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Boolean getThrowFlag() {
        return throwFlag;
    }

    public void setThrowFlag(Boolean throwFlag) {
        this.throwFlag = throwFlag;
    }

    public Boolean getPaintFlag() {
        return paintFlag;
    }

    public void setPaintFlag(Boolean paintFlag) {
        this.paintFlag = paintFlag;
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