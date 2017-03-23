package com.ujia.virgo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.ConstructionMapper;
import com.ujia.virgo.service.ConstructionServiceI;
import com.ujia.virgo.service.DataDictServiceI;
import com.ujia.vo.ConstructionVo;

/**
 * 发现服务实现类
 */
@Service("constructionService")
public class ConstructionServiceImpl implements ConstructionServiceI {

	@Autowired
	ConstructionMapper constructionMapper;
	@Autowired
	private DataDictServiceI dataDictService;

	@Override
	public List<ConstructionVo> constructionList() {
		return constructionMapper.getConstructionList();
	}

	@Override
	public ConstructionVo getConstructionDetails(String id) {

		return constructionMapper.getConstructionDetails(id);
	}

	@Override
	public Map<String, String> getConstructionAmount() {
		return dataDictService.construction();
	}

}