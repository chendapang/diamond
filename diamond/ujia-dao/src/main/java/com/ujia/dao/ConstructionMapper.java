package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Construction;
import com.ujia.vo.ConstructionVo;

public interface ConstructionMapper extends SqlMapper {
	public List<ConstructionVo> getConstructionList();

	public ConstructionVo getConstructionDetails(String id);

	//
	public Integer countConstruction(Map<String, Object> paramMap);

	public List<ConstructionVo> constructionList(Map<String, Object> paramMap);

	int deleteByPrimaryKey(String id);

	int insertSelective(Construction record);

	int updateByPrimaryKeySelective(Construction record);
	
	ConstructionVo selectByPrimaryKey(String id);
}