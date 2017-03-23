package com.ujia.lion.service;

import com.ujia.enums.ActivityStatus;
import com.ujia.model.Activity;
import com.ujia.utils.PageInfo;

/**
 * 活动业务
 * 
 * @author xx
 *
 */
public interface ActivityServiceI {
	
	/**
	 * 根据类型获取活动列表
	 * @param status	活动状态	(1：最新 2精选活动 3即将开始 4已下线)
	 * @param page		第n页
	 * @param pageNum	每页n条数据
	 * @return 
	 */
	PageInfo<Activity> getItems(ActivityStatus status, Integer pageNumber, Integer pageNum);

	Activity getItemById(String id);

	void deleteItemById(String id);

	void editItem(Activity a);
	
	
}