package com.ujia.lion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.OrderMapper;
import com.ujia.enums.OrderStatus;
import com.ujia.lion.service.OrderServiceI;
import com.ujia.model.Order;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.vo.OrderVo;

@Service
public class OrderServiceImpl implements OrderServiceI {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public PageInfo<OrderVo> getItems(Integer pageNumber, Integer pageSize,String contact,Integer type) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);
		param.put("contact", contact);
		param.put("type", type);

		Integer total = orderMapper.orderAccount();

		PageInfo<OrderVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<OrderVo> list = orderMapper.getOrders(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public OrderVo getItemById(String id) {
		
		OrderVo a = orderMapper.selectByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteItemById(String id) {
		orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editItem(Order a) {

		if (a != null && StringUtils.isNotBlank(a.getId())) {// 有id为编辑
			a.setStatusStr(OrderStatus.getOrderStatusByValue(a.getStatus()).getComment());
			orderMapper.updateByPrimaryKeySelective(a);

		} else {// 添加
			a.setId(SeqFactory.createId());
			orderMapper.insertSelective(a);
		}

	}

	
}