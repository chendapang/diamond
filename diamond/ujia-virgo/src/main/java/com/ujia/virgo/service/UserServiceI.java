package com.ujia.virgo.service;

import com.ujia.model.WxUser;
import com.ujia.utils.PageInfo;

public interface UserServiceI {




	/**
	 * 编辑用户信息
	 * 
	 * @param wxUserPO
	 */
	void editUserInfo(WxUser wxUserPO);

	/**
	 * 取消关注
	 * 
	 * @param userOpen_id
	 */
	void unsubscribe(String openid);




	WxUser getByOpenId(String openid);



	PageInfo<WxUser> userList(Integer pageSize, Integer pageNum);

	void editScan(String openId, String scanId);
}
