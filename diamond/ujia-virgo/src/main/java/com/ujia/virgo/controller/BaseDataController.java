package com.ujia.virgo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.enums.ArticleType;
import com.ujia.enums.DecorateType;
import com.ujia.model.EnumObject;

/**
 * 案例资源入口
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/baseData")
public class BaseDataController {

	

	/**
	 * 获取装修类型
	 *  url:/baseData/decorateType
	 * type：GET 
	 * result:{"JAPAN_TYPE":"日式","NORTHERN_EUROPE":"北欧","MODERN":"现代","LIGHT_AMERICAN":"轻美式","MASHUP":"混搭","LIGHT_INDUSTRY":"轻工业"}
	 */
	@RequestMapping(value = "/decorateType", method = RequestMethod.GET)
	@ResponseBody
	public List<EnumObject> decorateType() throws Exception {

		
 
		return DecorateType.getDecorateTypeList();
	}

	/**
	 * 获取文章类型
	 *  url:/baseData/articleType
	 *  type：GET 
	 *  result:{"PRE_DECORATE":"装前必读","MATERIAL_PURCHASE":"材料选购","CONSTRUCTION_TECH":"施工工艺","DESIGN_COLLOCATION":"设计搭配","UJIA_STORY":"U家故事"}
	 */

	@RequestMapping(value = "/articleType", method = RequestMethod.GET)
	@ResponseBody
	public List<EnumObject> articleType() throws Exception {

		return ArticleType.getArticleTypeList();
	}



}
