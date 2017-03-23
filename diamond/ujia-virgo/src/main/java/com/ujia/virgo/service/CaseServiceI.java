package com.ujia.virgo.service;

import java.util.List;

import com.ujia.enums.DecorateType;
import com.ujia.utils.PageInfo;
import com.ujia.vo.CaseVo;

/**
 * 案例服务接口
 * 
 * @author fisher
 *
 */
public interface CaseServiceI {

	/**
	 * 获取所有案例
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public PageInfo<CaseVo> getCases(Integer pageNumber, Integer pageSize, DecorateType decorateType, String searchParam);

	/**
	 * 通过ID获取案例
	 * 
	 * @param caseId
	 * @return
	 */
	public CaseVo getCase(String id);

	/**
	 * 获取所有案例
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public List<CaseVo> getCases(Integer type);
	
	/**
	 * 获取所有案例
	 * 
	 * @param num
	 * @param sticky
	 * @param page
	 * @param pre
	 * @return
	 */
	public List<CaseVo> getRecommendCases();

}