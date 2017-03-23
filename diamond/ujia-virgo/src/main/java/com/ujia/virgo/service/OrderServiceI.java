package com.ujia.virgo.service;

import java.util.Map;

import com.ujia.enums.OrderType;
import com.ujia.virgo.controller.jo.OrderJo;

/**
 * 案例服务接口
 * 
 * @author fisher
 *
 */
public interface OrderServiceI {

	/**
	 * 添加订单
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public String addOrer(OrderJo orderJo, OrderType orderType);

	public Map<String, Object> orderAccount();

}