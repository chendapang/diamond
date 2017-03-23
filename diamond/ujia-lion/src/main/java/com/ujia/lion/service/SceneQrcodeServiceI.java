package com.ujia.lion.service;

import com.ujia.model.WxSceneQrcode;
import com.ujia.utils.PageInfo;

/**
 * 微信管理业务
 * 
 * @author xx
 *
 */
public interface SceneQrcodeServiceI {


	PageInfo<WxSceneQrcode> getWxSceneQrcodeList(Integer pageIndex, Integer pageSize);

	WxSceneQrcode getItemById(String id);

	void editItem(WxSceneQrcode a);

	void deleteItemById(String id);



}