package com.ujia.virgo.service;

import java.util.List;

import com.ujia.enums.ArticleType;
import com.ujia.utils.PageInfo;
import com.ujia.vo.ArticleVo;

/**
 * 文章
 * 
 * @author abiao
 *
 */
public interface ArticleServiceI {

	/**
	 * 获取所有文章
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public PageInfo<ArticleVo> getArticles(Integer pageNumber, Integer pageSize, ArticleType articleType, String searchParam);

	/**
	 * 通过ID获取文章
	 * 
	 * @param caseId
	 * @return
	 */
	public ArticleVo getArticle(String id);

	/**
	 * 获取所有文章
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public List<ArticleVo> getArticles(Integer type);
}