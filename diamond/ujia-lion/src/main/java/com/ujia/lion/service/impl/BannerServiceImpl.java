package com.ujia.lion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.ujia.dao.BannerDetailsMapper;
import com.ujia.dao.BannerMapper;
import com.ujia.jo.BannerJo;
import com.ujia.lion.service.BannerServiceI;
import com.ujia.model.BannerDetails;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.vo.BannerVo;

@Service
public class BannerServiceImpl implements BannerServiceI {

	@Autowired
	private BannerMapper bannerMapper;
	@Autowired
	private BannerDetailsMapper bannerDetailsMapper;

	@Override
	public PageInfo<BannerVo> getItems(Integer pageNumber, Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);

		Integer total = bannerMapper.countBanner(param);

		PageInfo<BannerVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<BannerVo> list = bannerMapper.bannerList(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public BannerVo getItemById(String id) {

		BannerVo a = bannerMapper.selectAllByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteItemById(String id) {
		bannerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editItem(BannerJo a) {
				
		if (a != null && StringUtils.isNotBlank(a.getId())) {// 有id为编辑
			BannerVo old = bannerMapper.selectAllByPrimaryKey(a.getId());
			for(BannerDetails bannerDetails:old.getBannerDetailsList()){
				bannerDetailsMapper.deleteByPrimaryKey(bannerDetails.getId());
			}
			
			for(BannerDetails bannerDetails:a.getBannerDetailsList()){
				bannerDetails.setId(SeqFactory.createId());
				bannerDetails.setBannerId(a.getId());
				bannerDetailsMapper.insert(bannerDetails);
			}
			
			a.setBannerDatas(JSONArray.toJSONString(a.getBannerDetailsList()));
			
			bannerMapper.updateByPrimaryKeySelective(a);

		} else {// 添加
			String bannerId=SeqFactory.createId();
			a.setId(bannerId);
			
			for(BannerDetails bannerDetails:a.getBannerDetailsList()){
				bannerDetails.setId(SeqFactory.createId());
				bannerDetails.setBannerId(bannerId);
				bannerDetailsMapper.insert(bannerDetails);
			}
			
			a.setBannerDatas(JSONArray.toJSONString(a.getBannerDetailsList()));
			
			bannerMapper.insertSelective(a);
		}

	}

}