package com.fisher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fisher.api.MotanSampleService;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/motanSample")
public class MotanController {

	@Autowired
	@Qualifier("motanSampleService")
	private MotanSampleService motanSampleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public void reservation(String eleId, String page, String type, String url, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		motanSampleService.motanTest();

	}

}
