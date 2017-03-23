package com.ujia.dao;

import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.DataDict;
import com.ujia.vo.DataDictVo;

public interface DataDictMapper extends SqlMapper {

	public DataDictVo getDataDict(Map<String, Object> paramMap);

	public DataDict selectByKey(String key);

	int deleteByPrimaryKey(String id);

	int insert(DataDict record);

	int insertSelective(DataDict record);

	DataDict selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(DataDict record);

	int updateByPrimaryKey(DataDict record);

}