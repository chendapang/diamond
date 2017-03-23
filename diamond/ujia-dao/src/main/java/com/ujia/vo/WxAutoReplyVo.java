package com.ujia.vo;

import com.ujia.enums.MsgType;
import com.ujia.model.WxAutoReply;

public class WxAutoReplyVo extends WxAutoReply {

	public String getMsgTypeString() {
		MsgType msgType = MsgType.valueOf(getMsgType());
		
		return msgType==null?"":msgType.getComment();

	}
	public MsgType getMsgTypeEnum() {
		MsgType msgType = MsgType.valueOf(getMsgType());
		
		return msgType;
		
	}

}