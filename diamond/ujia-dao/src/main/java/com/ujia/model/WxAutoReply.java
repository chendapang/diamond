package com.ujia.model;

import java.util.Date;

public class WxAutoReply {
    private String id;

    private String userInput;

    private String sysReply;

    private String msgType;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput == null ? null : userInput.trim();
    }

    public String getSysReply() {
        return sysReply;
    }

    public void setSysReply(String sysReply) {
        this.sysReply = sysReply == null ? null : sysReply.trim();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}