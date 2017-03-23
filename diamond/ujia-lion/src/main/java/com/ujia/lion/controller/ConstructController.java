package com.ujia.lion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.jo.ConstructionJo;
import com.ujia.lion.service.ConstructServiceI;
import com.ujia.model.Construction;
import com.ujia.utils.PageInfo;
import com.ujia.utils.ResultMap;
import com.ujia.vo.ConstructionVo;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/construct")
public class ConstructController {

	@Autowired
	private ConstructServiceI constructServiceI;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(Integer pageIndex, //
			Integer pageSize, //
			Model model,String projectName) throws Exception {
		
		PageInfo<ConstructionVo> items = constructServiceI.getItems(pageIndex, pageSize,projectName);
		
		return items;
	}
	
	@RequestMapping(value = "/doGet", method = RequestMethod.GET)
	@ResponseBody
	public Object doGet(String id) throws Exception {
		
		
		ConstructionVo a = constructServiceI.getItemById(id);
		
		return ResultMap.getSuccessResultMap(a);
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Object doEdit(@RequestBody ConstructionJo a) throws Exception {
		
		constructServiceI.editItem(a);
		
		
		return ResultMap.getSuccessResultMap();
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@RequestBody Construction a) throws Exception {
		
		constructServiceI.deleteItemById(a.getId());
		
		return ResultMap.getSuccessResultMap();
	}
	
	
}
