package com.ujia.virgo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.enums.ArticleType;
import com.ujia.utils.PageInfo;
import com.ujia.virgo.service.ArticleServiceI;
import com.ujia.vo.ArticleVo;

/**
 * 文章
 * 
 * @author abiao
 *
 */
@Controller
@RequestMapping("/article")
public class ArticlesController{

	@Autowired
	private ArticleServiceI articleServiceI;

	/**
	 * 获取文章分页集合 
	 * url:/article/{pageNumber}/{pageSize}?articleType=QUWEI_TYPE 
	 * type：GET 
	 * result:{
			    "items": [
			        {
			            "id": "8a9aa8cc58b32f430158d38671100020",
			            "cover": "http://img.u-workshop.com//project/H2eDxMEPT8.png",
			            "title": "揭秘宜家的收纳精髓，从此再也不怕东西多啦！",
			            "tags": "222",
			            "page": "http://h5.u-workshop.com/article/items/8a9aa8cc58b32f430158d38671100020.html",
			            "authorName": "22",
			            "authorAvatar": "22",
			            "articleAbstract": "22"
			        }
			    ],
			    "total": 1,
			    "pageSize": 11,
			    "pages": 1,
			    "pageNumber": 1,
			    "hasPreviousPage": false,
			    "hasNextPage": false,
			    "navigatePageNumbers": [
			        1
			    ],
			    "startIndex": 0,
			    "lastPage": false,
			    "firstPage": true
			}
	 */
	@RequestMapping(value = "/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<ArticleVo> articles(HttpServletRequest request, @PathVariable("pageNumber") Integer pageNumber, //
			@PathVariable("pageSize") Integer pageSize, @RequestParam(required=false) ArticleType articleType, @RequestParam(required=false) String searchParam)
			throws Exception {

		PageInfo<ArticleVo> pageInfo = articleServiceI.getArticles(pageNumber, pageSize, articleType,searchParam);

		return pageInfo;
	}

	/**
	 * 获取文章
	 * url:/article/{id}
	 * type：GET 
	 * result:{
				    "id": "8a9aa8cc58b32f430158d38671100020",
				    "cover": "http://img.u-workshop.com//project/H2eDxMEPT8.png",
				    "title": "揭秘宜家的收纳精髓，从此再也不怕东西多啦！",
				    "tags": "222",
				    "pageContent": "adfasdf",
				    "authorName": "22",
				    "authorAvatar": "22",
				    "mediaUrl":"dadfasdf"
				}
	 */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ArticleVo article(HttpServletRequest request, @PathVariable("id") String id) throws Exception {

		return articleServiceI.getArticle(id);
	}
	
	/**
	 * 通过案例类型获取案例
	 * url:/article?articleType=QUWEI_TYPE 
	 * type：GET 
	 * result:[
				    {
				        "id": "8a9aa8cc58b32f430158d38671100020",
				        "cover": "http://img.u-workshop.com//project/H2eDxMEPT8.png",
				        "title": "揭秘宜家的收纳精髓，从此再也不怕东西多啦！",
				        "tags": "222",
				        "page": "http://h5.u-workshop.com/article/items/8a9aa8cc58b32f430158d38671100020.html"
				    }
				]
	 */
	@RequestMapping( method = RequestMethod.GET)
	@ResponseBody
	public List<ArticleVo> articlesByArticleType(HttpServletRequest request, @RequestParam(defaultValue = "QUWEI_TYPE") ArticleType articleType)
			throws Exception {

		

		return articleServiceI.getArticles(articleType.getValue());
	}
}
