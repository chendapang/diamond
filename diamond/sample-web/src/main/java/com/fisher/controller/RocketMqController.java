package com.fisher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fisher.service.RocketMqServiceI;

/**
 * 访问入口
 * @author fisher
 *
 */
@Controller
@RequestMapping("/rocketMq")
public class RocketMqController {

	@Autowired
	private RocketMqServiceI rocketMqService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public void reservation(String eleId,String page, String type,String url,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		//解决跨域问题
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Origin", "*");

		rocketMqService.sendToMq();

	}
	

}
