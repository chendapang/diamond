package com.ujia.virgo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.ActivityMapper;
import com.ujia.enums.ActivityStatus;
import com.ujia.model.Activity;
import com.ujia.utils.PageInfo;
import com.ujia.virgo.service.ActivityServiceI;

@Service
public class ActivityServiceImpl implements ActivityServiceI {

	@Autowired
	private ActivityMapper activityMapper;

	@Override
	public PageInfo<Activity> getItems(ActivityStatus status, Integer pageNumber, Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);

		param.put("status", status.name());
		
		Integer total = activityMapper.getActivityCount(param);

		PageInfo<Activity> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<Activity> list = activityMapper.getActivityList(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

}