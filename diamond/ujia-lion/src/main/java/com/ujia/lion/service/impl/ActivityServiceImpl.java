package com.ujia.lion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.ActivityMapper;
import com.ujia.enums.ActivityStatus;
import com.ujia.lion.service.ActivityServiceI;
import com.ujia.model.Activity;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;

@Service
public class ActivityServiceImpl implements ActivityServiceI {

	@Autowired
	private ActivityMapper activityMapper;

	@Override
	public PageInfo<Activity> getItems(ActivityStatus status, Integer pageNumber, Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);

		if(status!=null){
			param.put("status", status.name());
		}
		
		Integer total = activityMapper.getActivityCount(param);

		PageInfo<Activity> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<Activity> list = activityMapper.getActivityList(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public Activity getItemById(String id) {
		Activity a = activityMapper.selectByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteItemById(String id) {
		activityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editItem(Activity a) {
		
		
		if(a!=null && StringUtils.isNotBlank(a.getId())){//有id为编辑
			activityMapper.updateByPrimaryKeySelective(a);
			
		}else{//添加
			a.setId(SeqFactory.createId());
			activityMapper.insertSelective(a);
		}
		
	}

}