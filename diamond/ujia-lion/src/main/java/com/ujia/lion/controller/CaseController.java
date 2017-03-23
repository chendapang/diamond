package com.ujia.lion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.lion.service.CaseServiceI;
import com.ujia.model.Case;
import com.ujia.utils.PageInfo;
import com.ujia.utils.ResultMap;
import com.ujia.vo.CaseVo;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/case")
public class CaseController {

	@Autowired
	private CaseServiceI caseServiceI;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(Integer pageIndex, //
			Integer pageSize, //
			Model model) throws Exception {
		
		PageInfo<CaseVo> items = caseServiceI.getItems(null, pageIndex, pageSize);
		
		return items;
	}
	
	@RequestMapping(value = "/doGet", method = RequestMethod.GET)
	@ResponseBody
	public Object doGet(String id) throws Exception {
		
		
		CaseVo a = caseServiceI.getItemById(id);
		
		return ResultMap.getSuccessResultMap(a);
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Object doEdit(@RequestBody Case a) throws Exception {
		
		caseServiceI.editItem(a);
		
		
		return ResultMap.getSuccessResultMap();
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@RequestBody Case a) throws Exception {
		
		caseServiceI.deleteItemById(a.getId());
		
		return ResultMap.getSuccessResultMap();
	}
	
	
}
