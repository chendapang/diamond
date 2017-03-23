package com.ujia.service;

import com.ujia.model.DataDict;

public interface SystemDataDicService {

	String getByKey(String key);

	void insert(DataDict dataDict);

}
