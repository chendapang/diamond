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

import com.ujia.enums.DecorateType;
import com.ujia.utils.PageInfo;
import com.ujia.virgo.service.CaseServiceI;
import com.ujia.vo.CaseVo;

/**
 * 案例资源入口
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/case")
public class CaseController {

	@Autowired
	private CaseServiceI caseService;

	/**
	 * 获取案例分页集合
	 *  url:/case/{pageNumber}/{pageSize}?decorateType=JAPAN_TYPE
	 * type：GET 
	 * result:{
			    "items": [
			        {
			            "id": "402881c7570e366701570e4b40e00002",
			            "buildingName": "555",
			            "houseStyle": "三室",
			            "houseArea": "89",
			            "costAmount": "10万",
			            "designerName": "55",
			            "designerAvatar": "566",
			            "pageUrl": "http://h5.u-workshop.com/case/items/402881c7570e366701570e4b40e00002.html",
			            "coverUrl": "http://img.u-workshop.com//project/FyGmZ7HfRE.jpg";"tag": "日式"
			        }
			    ],
			    "total": 2,
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
	public PageInfo<CaseVo> cases(HttpServletRequest request, @PathVariable("pageNumber") Integer pageNumber, //
			@PathVariable("pageSize") Integer pageSize, @RequestParam(required = false) DecorateType decorateType,
			@RequestParam(required = false) String searchParam) throws Exception {

		PageInfo<CaseVo> pageInfo = caseService.getCases(pageNumber, pageSize, decorateType, searchParam);

		return pageInfo;
	}

	/**
	 * 获取案例详情
	 *  url:/case/{id} 
	 *  type：GET 
	 *  result:{
				    "buildingName": "555",
				    "houseStyle": "三室",
				    "houseArea": "89",
				    "costAmount": "10万",
				    "designerName": "55",
				    "designerAvatar": "566",
				    "coverUrl": "http://img.u-workshop.com//project/FyGmZ7HfRE.jpg",
				    "context": "WERTWFG",
				    "author": "666",
				    "tag": "日式"
				}
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CaseVo cases(HttpServletRequest request, @PathVariable("id") String id) throws Exception {

		return caseService.getCase(id);
	}

	/**
	 * 通过案例类型获取案例 
	 * url:/case?decorateType=JAPAN_TYPE 
	 * type：GET 
	 * result:[
				    {
				        "id": "402881c7570e366701570e4b40e00002",
				        "buildingName": "555",
				        "houseStyle": "三室",
				        "houseArea": "89",
				        "costAmount": "10万",
				        "designerName": "55",
				        "designerAvatar": "566",
				        "pageUrl": "http://h5.u-workshop.com/case/items/402881c7570e366701570e4b40e00002.html",
				        "coverUrl": "http://img.u-workshop.com//project/FyGmZ7HfRE.jpg",
				        "tag": "日式"
				    }
				]
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<CaseVo> cases(HttpServletRequest request,
			@RequestParam(defaultValue = "JAPAN_TYPE") DecorateType decorateType) throws Exception {

		return caseService.getCases(decorateType.getValue());
	}
	
	/**
	 * 获取推荐案例
	 *  url:/case?decorateType=JAPAN_TYPE 
	 *  type：GET 
	 *  result:[
				    {
				        "id": *"402881c7570e366701570e4b40e00002",
				        "buildingName": "555",
				        "houseStyle": *"三室",
				        "houseArea": "89",
				        "costAmount": "10万",
				        "designerName": "55",
				        *"designerAvatar": "566",
				        "pageUrl": *"http://h5.u-workshop.com/case/items/402881c7570e366701570e4b40e00002.html",
				        *"coverUrl": "http://img.u-workshop.com//project/FyGmZ7HfRE.jpg",
				        *"tag": "日式"
				    }
				]
	 */
	@RequestMapping(value="recommendCase" ,method = RequestMethod.GET)
	@ResponseBody
	public List<CaseVo> recommendCases(HttpServletRequest request) throws Exception {

		return caseService.getRecommendCases();
	}

}
