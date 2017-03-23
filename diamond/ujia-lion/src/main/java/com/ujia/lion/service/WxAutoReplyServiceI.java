package com.ujia.lion.service;

import com.ujia.model.WxAutoReply;
import com.ujia.utils.PageInfo;
import com.ujia.vo.WxAutoReplyVo;

/**
 * 自动回复业务
 * 
 * @author xx
 *
 */
public interface WxAutoReplyServiceI {

	PageInfo<WxAutoReplyVo> getAutoReplyList(Integer pageIndex, Integer pageSize);

	WxAutoReply getItemById(String id);

	void editItem(WxAutoReply a);

	void deleteItemById(String id);}