package com.ujia.lion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.ConstructionMapper;
import com.ujia.jo.ConstructionJo;
import com.ujia.lion.service.ConstructServiceI;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.vo.ConstructionVo;

@Service
public class ConstructServiceImpl implements ConstructServiceI {

	@Autowired
	private ConstructionMapper constructionMapper;

	@Override
	public PageInfo<ConstructionVo> getItems(Integer pageNumber, Integer pageSize,String projectName) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);
		param.put("projectName", projectName);

		Integer total = constructionMapper.countConstruction(param);

		PageInfo<ConstructionVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<ConstructionVo> list = constructionMapper.constructionList(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public ConstructionVo getItemById(String id) {
		
		ConstructionVo a = constructionMapper.selectByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteItemById(String id) {
		constructionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editItem(ConstructionJo a) {
		StringBuffer sb=new StringBuffer();
		
		for(String url:a.getPicUrlList()){
			sb.append(url);
			sb.append(";");
		}
		
		a.setPicAmount(a.getPicUrlList().size());
		
		if (a != null && StringUtils.isNotBlank(a.getId())) {// 有id为编辑
			a.setPicUrls(sb.substring(0, sb.length()));
			constructionMapper.updateByPrimaryKeySelective(a);

		} else {// 添加
			a.setId(SeqFactory.createId());
			a.setPicUrls(sb.substring(0, sb.length()));
			constructionMapper.insertSelective(a);
		}

	}

}