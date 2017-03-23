package com.ujia.virgo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.DataDictMapper;
import com.ujia.virgo.service.DataDictServiceI;
import com.ujia.vo.DataDictVo;

/**
 * 发现服务实现类
 */
@Service("dataDictService")
public class DataDictServiceImpl implements DataDictServiceI {

	@Autowired
	DataDictMapper dataDictMapper;

	@Override
	public Map<String, String> construction() {
		Map<String, Object> paramMap = new HashMap<>();
		Map<String, String> resultMap = new HashMap<>();
		paramMap.put("dictKey", "processs");

		DataDictVo processsVo = dataDictMapper.getDataDict(paramMap);

		

		resultMap.put("processs", processsVo.getDictComment());

		return resultMap;
	}

}