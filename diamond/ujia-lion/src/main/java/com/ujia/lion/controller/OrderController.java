package com.ujia.lion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.lion.service.OrderServiceI;
import com.ujia.model.Order;
import com.ujia.utils.PageInfo;
import com.ujia.utils.ResultMap;
import com.ujia.vo.OrderVo;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServiceI orderServiceI;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(Integer pageIndex, //
			Integer pageSize, //
			Model model,String contact,Integer type) throws Exception {
		
		PageInfo<OrderVo> items = orderServiceI.getItems( pageIndex, pageSize,contact,type);
		
		return items;
	}
	
	@RequestMapping(value = "/doGet", method = RequestMethod.GET)
	@ResponseBody
	public Object doGet(String id) throws Exception {
		
		
		OrderVo a = orderServiceI.getItemById(id);
		
		return ResultMap.getSuccessResultMap(a);
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Object doEdit(@RequestBody Order a) throws Exception {
		
		orderServiceI.editItem(a);
		
		
		return ResultMap.getSuccessResultMap();
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@RequestBody Order a) throws Exception {
		
		orderServiceI.deleteItemById(a.getId());
		
		return ResultMap.getSuccessResultMap();
	}
	
	
}
