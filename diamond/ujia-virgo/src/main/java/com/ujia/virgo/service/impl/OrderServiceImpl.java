package com.ujia.virgo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ujia.dao.OrderMapper;
import com.ujia.enums.OrderStatus;
import com.ujia.enums.OrderType;
import com.ujia.model.Order;
import com.ujia.utils.SeqFactory;
import com.ujia.virgo.controller.jo.OrderJo;
import com.ujia.virgo.service.OrderServiceI;

/**
 * 案例服务实现类
 */
@Service("orderService")
public class OrderServiceImpl implements OrderServiceI {

	@Autowired
	OrderMapper orderMapper;

	@Override
	public String addOrer(OrderJo orderJo, OrderType orderType) {
		String resultStr = new String();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();

		metaDataMap.put("fromPage", orderJo.getFromPage());
		metaDataMap.put("fromCase", orderJo.getFromCase());

		Order order = new Order();

		BeanUtils.copyProperties(orderJo, order);
		order.setId(SeqFactory.createId());
		order.setMetaData(JSONObject.toJSONString(metaDataMap));
		order.setStatus(OrderStatus.NOT_HANDLE.getValue());
		order.setType(orderType.getValue());
		order.setTypeStr(orderType.getComment());
		order.setStatusStr(OrderStatus.NOT_HANDLE.getComment());

		if (orderMapper.insert(order) == 1) {
			resultStr="预约成功，稍后小U顾问会联系您！";
		} else {
			resultStr="预约失败";
		}
		return resultStr;
	}

	@Override
	public Map<String, Object> orderAccount() {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("orderAccount", orderMapper.orderAccount());
		return resultMap;
	}

}