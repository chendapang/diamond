package com.ujia.virgo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujia.model.BannerDetails;
import com.ujia.virgo.service.BannerServiceI;

/**
 * 轮播入口
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerServiceI bannerService;


	
	/**
	 * 通过键获取轮播
	 *  url:banner/key1
	 *  type：GET
	 *  result:[
				    {
				        "image": "http://img.u-workshop.com//project/HYhTSfniCY.jpg",
				        "title": "首页头图",
				        "ref": "http://m.u-workshop.com/wechat_index.html?source_ref=APP"
				    }
				]
	 */
	@RequestMapping(value = "{bannerKey}",method = RequestMethod.GET)
	@ResponseBody
	public List<BannerDetails> getBannerDetailsByKey(HttpServletRequest request,@PathVariable("bannerKey") String bannerKey) throws Exception {

		return bannerService.getBannerByKey(bannerKey);
	}

}
