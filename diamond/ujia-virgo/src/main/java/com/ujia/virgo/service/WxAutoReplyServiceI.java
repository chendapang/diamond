package com.ujia.virgo.service;

import com.ujia.utils.wx.BaseMessage;

public interface WxAutoReplyServiceI {

	BaseMessage createMessageByUserInput(String user_input);
}

