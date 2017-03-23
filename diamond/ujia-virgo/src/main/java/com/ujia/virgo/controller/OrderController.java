package com.ujia.virgo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.enums.OrderType;
import com.ujia.utils.ResultMap;
import com.ujia.virgo.controller.jo.OrderJo;
import com.ujia.virgo.service.OrderServiceI;

/**
 * 预约入口
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServiceI orderService;

	/**
	 * 新增预约
	 *  url:order?orderType=ORDER_NORMAL
	 *  request param:{
					    "contact": "13540439711", 
					    "building": "复地复地御香山",
					    "designerName": "死死死gay 山",
					    "comment": "我是备注", 
					    "fromPage": "www.baidu.com",
					    "fromCase":" 我是案例"
					}
	 * type：POST
	 *  result:{
				  "msg": "预约成功，稍后小U顾问会联系您！"
				}
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object addOrer(HttpServletRequest request, @RequestBody OrderJo orderJo, //
			@RequestParam OrderType orderType) throws Exception {

		return ResultMap.getSuccessResultMap(orderService.addOrer(orderJo, orderType));
	}
	
	/**
	 * 获取预约数量
	 *  url:order/account
	 *  request param:
	 *  type：GET
	 *  result:{
				  "data": "预约成功，稍后小U顾问会联系您！",
				  "success": true
				}
	 */
	@RequestMapping(value="account",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> account(HttpServletRequest request) throws Exception {

		return orderService.orderAccount();
	}

}
