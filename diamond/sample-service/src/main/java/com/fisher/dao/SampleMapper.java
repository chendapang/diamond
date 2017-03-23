package com.fisher.dao;

import com.fisher.mybatis.SqlMapper;

public interface SampleMapper extends SqlMapper {
	/**
	 * 新增工单
	 * 
	 * @param workorder
	 * @return
	 */
	public int sampleTest();

}