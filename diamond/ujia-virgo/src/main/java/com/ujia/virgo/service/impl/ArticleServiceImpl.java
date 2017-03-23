package com.ujia.virgo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.ArticleMapper;
import com.ujia.enums.ArticleType;
import com.ujia.utils.PageInfo;
import com.ujia.virgo.service.ArticleServiceI;
import com.ujia.vo.ArticleVo;

@Service
public class ArticleServiceImpl implements ArticleServiceI {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<ArticleVo> getArticles(Integer pageNumber, Integer pageSize, ArticleType articleType,
			String searchParam) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);

		if (articleType != null) {
			paramMap.put("articleTypeKey", articleType.getValue());
		}
		if(searchParam!=null){
			paramMap.put("searchParam", searchParam.trim());
		}

		

		Integer total = articleMapper.countArticle(paramMap);

		PageInfo<ArticleVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		paramMap.put("startIndex", pageInfo.getStartIndex());
		paramMap.put("pageSize", pageInfo.getPageSize());
		List<ArticleVo> list = articleMapper.getArticles(paramMap);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public ArticleVo getArticle(String id) {
		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("id", id);

		return articleMapper.getArticle(paramMap);
	}

	@Override
	public List<ArticleVo> getArticles(Integer type) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("limit", 5);
		paramMap.put("articleTypeKey", type);

		return articleMapper.getArticlesLimit(paramMap);
	}

}