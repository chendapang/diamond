package com.ujia.virgo.service;

import java.util.List;

import com.ujia.model.BannerDetails;

/**
 * 案例服务接口
 * 
 * @author fisher
 *
 */
public interface BannerServiceI {

	/**
	 * 添加订单
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public List<BannerDetails> getBannerByKey(String bannerKey);

}