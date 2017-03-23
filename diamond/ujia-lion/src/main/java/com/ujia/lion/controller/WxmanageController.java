package com.ujia.lion.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.lion.service.WxmanageServiceI;
import com.ujia.utils.PageInfo;
import com.ujia.utils.ResultMap;
import com.ujia.vo.WxMenuButtonVo;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/wxmanage")
public class WxmanageController {

	@Autowired
	private WxmanageServiceI wxmanageServiceI;

	
	
	/**
	 * 获取素材列表
	 * @param tabName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMaterialList", method = RequestMethod.GET)
	@ResponseBody
	public Object getMaterialList(
			String tabName, //
			Integer pageIndex, //
			Integer pageSize) throws Exception {
		
		PageInfo<Object> items = wxmanageServiceI.getMaterialList(tabName, pageIndex, pageSize);
		
		return items;
	}
	
	/**
	 * 获取菜单列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMenuList", method = RequestMethod.GET)
	@ResponseBody
	public Object getMenuList() throws Exception {
		
		 List<WxMenuButtonVo> menuList = wxmanageServiceI.getMenuList();
		
		return ResultMap.getSuccessResultMap(menuList);
	}
	/**
	 * 保存菜单
	 * @param button
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object saveMenu(@RequestBody WxMenuButtonVo[] button) throws Exception {
		
		List<WxMenuButtonVo> asList = Arrays.asList(button);
		wxmanageServiceI.saveMenu(asList);
		
		
		return ResultMap.getSuccessResultMap();
	}
	
	
	
}
