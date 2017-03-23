package com.ujia.lion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 访问入口
 * 
 * @author fisher
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {


	@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	public String pageName(@PathVariable String pageName,Model model) throws Exception {
		System.out.println("pageName="+pageName);
		
		return pageName;
	}

	@RequestMapping(value = "/{folder}/{pageName}", method = RequestMethod.GET)
	public String folder_pageName(@PathVariable String folder,@PathVariable String pageName,Model model) throws Exception {
		System.out.println("folder/pageName = "+folder+"/"+pageName);
		
		return folder+"/"+pageName;
	}
	@RequestMapping(value = "/{folder1}/{folder2}/{pageName}", method = RequestMethod.GET)
	public String folder1_folder2_pageName(
			@PathVariable String folder1,
			@PathVariable String folder2,
			@PathVariable String pageName,Model model) throws Exception {
		
		
		System.out.println("folder1/folder2/pageName = "+folder1+"/"+folder2+"/"+pageName);
		
		return folder1+"/"+folder2+"/"+pageName;
	}
}
