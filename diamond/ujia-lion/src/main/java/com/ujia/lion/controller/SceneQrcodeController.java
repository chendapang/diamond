package com.ujia.lion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.lion.service.SceneQrcodeServiceI;
import com.ujia.model.WxSceneQrcode;
import com.ujia.utils.PageInfo;
import com.ujia.utils.ResultMap;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/sceneQrcode")
public class SceneQrcodeController {

	@Autowired
	private SceneQrcodeServiceI sceneQrcodeServiceI;
	/**
	 * 获取场景二维码列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(
			Integer pageIndex, //
			Integer pageSize) throws Exception {
		
		PageInfo<WxSceneQrcode> items = sceneQrcodeServiceI.getWxSceneQrcodeList(pageIndex, pageSize);
		
		return items;
	}
	
	@RequestMapping(value = "/doGet", method = RequestMethod.GET)
	@ResponseBody
	public Object doGet(String id) throws Exception {
		
		
		WxSceneQrcode a = sceneQrcodeServiceI.getItemById(id);
		
		return ResultMap.getSuccessResultMap(a);
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Object doEdit(@RequestBody WxSceneQrcode a) throws Exception {
		
		sceneQrcodeServiceI.editItem(a);
		
		
		return ResultMap.getSuccessResultMap();
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@RequestBody WxSceneQrcode a) throws Exception {
		
		sceneQrcodeServiceI.deleteItemById(a.getId());
		
		return ResultMap.getSuccessResultMap();
	}
	
	

}
