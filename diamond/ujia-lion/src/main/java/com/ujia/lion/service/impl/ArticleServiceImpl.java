package com.ujia.lion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.ArticleMapper;
import com.ujia.enums.ActivityStatus;
import com.ujia.enums.ArticleType;
import com.ujia.lion.service.ArticleServiceI;
import com.ujia.model.Article;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.vo.ArticleVo;

@Service
public class ArticleServiceImpl implements ArticleServiceI {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<ArticleVo> getItems(ActivityStatus status, Integer pageNumber, Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);

		if (status != null) {
			param.put("status", status.name());
		}

		Integer total = articleMapper.countArticle(param);

		PageInfo<ArticleVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<ArticleVo> list = articleMapper.getArticles(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public ArticleVo getItemById(String id) {
		
		ArticleVo a = articleMapper.selectByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteItemById(String id) {
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editItem(Article a) {

		if (a != null && StringUtils.isNotBlank(a.getId())) {// 有id为编辑
			a.setArticleType(ArticleType.getArticleTypeByValue(a.getArticleTypeKey()).getComment());
			articleMapper.updateByPrimaryKeySelective(a);

		} else {// 添加
			a.setId(SeqFactory.createId());
			a.setArticleType(ArticleType.getArticleTypeByValue(a.getArticleTypeKey()).getComment());
			articleMapper.insertSelective(a);
		}

	}

	
}