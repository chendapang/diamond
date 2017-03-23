package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Article;
import com.ujia.vo.ArticleVo;

public interface ArticleMapper extends SqlMapper{
	/**
	 * 获取案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<ArticleVo> getArticles(Map<String, Object> paramMap);

	/**
	 * 统计案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public Integer countArticle(Map<String, Object> paramMap);

	/**
	 * 获取一个案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public ArticleVo getArticle(Map<String, Object> paramMap);

	/**
	 * 获取一个案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<ArticleVo> getArticlesLimit(Map<String, Object> paramMap);
	
	ArticleVo selectByPrimaryKey(String id);
	
	int updateByPrimaryKeySelective(Article record);
	int updateByPrimaryKey(Article record);
	int deleteByPrimaryKey(String id);
	int insertSelective(Article record);
}