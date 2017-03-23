package com.ujia.virgo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.virgo.service.ConstructionServiceI;
import com.ujia.vo.ConstructionVo;

/**
 * 发现资源入口
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/construction")
public class ConstructionController {

	
	@Autowired
	private ConstructionServiceI constructionService;

	/**
	 * 获取在建工地数量
	 * url:/construction/amount
	 * type：GET
	 * result:{"processs":"502"}
	 */
	@RequestMapping(value = "/amount",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> amount(HttpServletRequest request) throws Exception {

		return constructionService.getConstructionAmount();
	}
	
	/**
	 * 获取在工地地址集合
	 * url:/construction/constructionList
	 * type：GET
	 * result:[{"id":"8a9aa8cc571de1a50157214335f70002","projectName":"南阳锦城晶品","lat":30.521614,"lng":104.07604,"address":"双流区天府大道南段846号(大城际对面)"}]
	 */
	@RequestMapping(value = "/constructionList",method = RequestMethod.GET)
	@ResponseBody
	public List<ConstructionVo> constructionList(HttpServletRequest request) throws Exception {

		return constructionService.constructionList();
	}

	/**
	 * 获取在工地地址集合
	 * url:/construction/{id}
	 * type：GET
	 * result:{"id":"8a9aa8cc571de1a50157214335f70002","constructionStatus":"啊啊啊","area":143,"cost":123.57,"picCover":"111","picAmount":33,"picUrlList":["AAA.COM","BBB.COM"]}
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ConstructionVo getConstructionDetails(HttpServletRequest request, //
			@PathVariable("id") String id) {
		return constructionService.getConstructionDetails(id);
	}

}
