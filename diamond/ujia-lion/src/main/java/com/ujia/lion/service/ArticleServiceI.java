package com.ujia.lion.service;

import com.ujia.enums.ActivityStatus;
import com.ujia.model.Article;
import com.ujia.utils.PageInfo;
import com.ujia.vo.ArticleVo;

/**
 * 活动业务
 * 
 * @author xx
 *
 */
public interface ArticleServiceI {
	
	/**
	 * 根据类型获取活动列表
	 * @param status	活动状态	(1：最新 2精选活动 3即将开始 4已下线)
	 * @param page		第n页
	 * @param pageNum	每页n条数据
	 * @return 
	 */
	PageInfo<ArticleVo> getItems(ActivityStatus status, Integer pageNumber, Integer pageNum);

	ArticleVo getItemById(String id);

	void deleteItemById(String id);

	void editItem(Article a);
	
	
}