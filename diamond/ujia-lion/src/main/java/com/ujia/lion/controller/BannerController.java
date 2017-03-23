package com.ujia.lion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.jo.BannerJo;
import com.ujia.lion.service.BannerServiceI;
import com.ujia.model.Construction;
import com.ujia.utils.PageInfo;
import com.ujia.utils.ResultMap;
import com.ujia.vo.BannerVo;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerServiceI bannerServiceI;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(Integer pageIndex, //
			Integer pageSize, //
			Model model) throws Exception {
		
		PageInfo<BannerVo> items = bannerServiceI.getItems(pageIndex, pageSize);
		
		return items;
	}
	
	@RequestMapping(value = "/doGet", method = RequestMethod.GET)
	@ResponseBody
	public Object doGet(String id) throws Exception {
		
		
		BannerVo a = bannerServiceI.getItemById(id);
		
		return ResultMap.getSuccessResultMap(a);
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Object doEdit(/*@RequestBody*/ BannerJo a) throws Exception {
		
		bannerServiceI.editItem(a);
		
		
		return ResultMap.getSuccessResultMap();
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@RequestBody Construction a) throws Exception {
		
		bannerServiceI.deleteItemById(a.getId());
		
		return ResultMap.getSuccessResultMap();
	}
	
	
}
