package com.ujia.vo;

import java.util.List;

import com.ujia.model.DataDict;

public class DataDictVo extends DataDict {

	// autoEnd
	/**
	 * 下级字典
	 */
	private List<DataDictVo> childDict;

	public List<DataDictVo> getChildDict() {
		return childDict;
	}

	public void setChildDict(List<DataDictVo> childDict) {
		this.childDict = childDict;
	}
	
	


}