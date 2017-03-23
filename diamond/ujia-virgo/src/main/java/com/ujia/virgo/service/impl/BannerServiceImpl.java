package com.ujia.virgo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.ujia.dao.BannerMapper;
import com.ujia.model.Banner;
import com.ujia.model.BannerDetails;
import com.ujia.virgo.service.BannerServiceI;

/**
 * 案例服务实现类
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerServiceI {

	

	@Autowired
	BannerMapper bannerMapper;

	@Override
	public List<BannerDetails> getBannerByKey(String bannerKey) {
		Banner banner=bannerMapper.selectByKey(bannerKey);
		return JSONArray.parseArray(banner.getBannerDatas(), BannerDetails.class);
	}


	

	
}