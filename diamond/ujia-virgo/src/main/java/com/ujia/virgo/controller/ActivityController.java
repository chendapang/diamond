package com.ujia.virgo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.enums.ActivityStatus;
import com.ujia.model.Activity;
import com.ujia.utils.PageInfo;
import com.ujia.virgo.service.ActivityServiceI;

/**
 * 活动
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityServiceI activityServiceI;

	/**
	 * 获取活动列表 url:activity/items?status=newest&pageNumber=1&pageSize=3
	 * 
	 * @param status
	 *            活动状态
	 * @param pageNumber
	 *            第n页
	 * @param pageSize
	 *            每页n条
	 * @return {"items":[{"id":"11a","title":"1","thumb":"1","href":"1",
	 *         "startTime":"2017-03-06 16:51:25","endTime":"2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"},{"id":"11wa","title":"1","thumb":
	 *         "1","href":"1","startTime":"2017-03-06 16:51:20","endTime":
	 *         "2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"},{"id":"1a","title":"1","thumb":"1"
	 *         ,"href":"1","startTime":"2017-03-06 16:51:11","endTime":
	 *         "2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"},{"id":"11","title":"1","thumb":"1"
	 *         ,"href":"1","startTime":"2017-03-06 16:51:05","endTime":
	 *         "2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"},{"id":"1","title":"1","thumb":"1",
	 *         "href":"1","startTime":"2017-03-06 16:51:01","endTime":
	 *         "2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"}],"nextObj":{"id":"11w","title":"1"
	 *         ,"thumb":"1","href":"1","startTime":"2017-03-06 16:51:00"
	 *         ,"endTime":"2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"},"total":10,"pageSize":6,"pages":2,
	 *         "pageNumber":1,"hasPreviousPage":false,"hasNextPage":true,
	 *         "navigatePageNumbers":[1,2],"first":{"id":"11a","title":"1",
	 *         "thumb":"1","href":"1","startTime":"2017-03-06 16:51:25"
	 *         ,"endTime":"2017-03-28 16:51:52"
	 *         ,"boutique":true,"digest":"1"},"startIndex":0,"firstPage":true,
	 *         "lastPage":false}
	 * @throws Exception
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	@ResponseBody
	public Object items(ActivityStatus status, //
			Integer pageNumber, //
			Integer pageSize, //
			HttpServletRequest request) throws Exception {

		PageInfo<Activity> items = activityServiceI.getItems(status, pageNumber, pageSize);

		return items;
	}

}
