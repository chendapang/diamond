package com.ujia.lion.service;

import java.util.List;

import com.ujia.utils.PageInfo;
import com.ujia.vo.WxMenuButtonVo;

/**
 * 微信管理业务
 * 
 * @author xx
 *
 */
public interface WxmanageServiceI {

	PageInfo<Object> getMaterialList(String tabName, Integer pageIndex, Integer pageSize);

	 List<WxMenuButtonVo> getMenuList();

	void saveMenu(List<WxMenuButtonVo> buttons);

}