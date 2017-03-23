package com.ujia.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.DataDictMapper;
import com.ujia.model.DataDict;
import com.ujia.service.SystemDataDicService;
import com.ujia.utils.SeqFactory;

@Service
public class SystemDataDicServiceImpl implements SystemDataDicService {

	@Autowired
	private DataDictMapper dataDictMapper;

	@Override
	public String getByKey(String key) {
		if (StringUtils.isBlank(key)) {
			return "";
		}

		DataDict dd = dataDictMapper.selectByKey(key);
		if (dd == null) {
			return "";
		}

		return dd.getDictValue();
	}

	@Override
	public void insert(DataDict dataDict) {
		
		DataDict _po = dataDictMapper.selectByKey(dataDict.getDictKey());
		if (_po != null) {
			dataDict.setId(_po.getId());
			BeanUtils.copyProperties(dataDict, _po);
			dataDictMapper.updateByPrimaryKey(_po);
		} else {
			
			dataDict.setId(SeqFactory.createId());
			dataDictMapper.insert(dataDict);
		}
		
	}

}
