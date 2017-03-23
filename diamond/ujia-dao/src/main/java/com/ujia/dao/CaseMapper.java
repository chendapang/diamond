package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Case;
import com.ujia.vo.CaseVo;

public interface CaseMapper extends SqlMapper {
	/**
	 * 获取案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<CaseVo> getCases(Map<String, Object> paramMap);

	/**
	 * 统计案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public Integer countCase(Map<String, Object> paramMap);

	/**
	 * 获取一个案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public CaseVo getCase(Map<String, Object> paramMap);

	/**
	 * 获取一个案例
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<CaseVo> getCasesLimit(Map<String, Object> paramMap);
	
	int deleteByPrimaryKey(String id);
	
	int updateByPrimaryKeySelective(Case record);
	
	int insertSelective(Case record);
	
	public List<CaseVo> getCaseList(Map<String, Object> paramMap);
	
	
	CaseVo selectByPrimaryKey(String id);

}