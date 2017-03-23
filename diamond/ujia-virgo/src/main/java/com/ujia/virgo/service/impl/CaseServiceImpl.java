package com.ujia.virgo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.CaseMapper;
import com.ujia.enums.DecorateType;
import com.ujia.utils.PageInfo;
import com.ujia.virgo.service.CaseServiceI;
import com.ujia.vo.CaseVo;

/**
 * 案例服务实现类
 */
@Service("caseService")
public class CaseServiceImpl implements CaseServiceI {

	@Autowired
	CaseMapper caseMapper;

	@Override
	public PageInfo<CaseVo> getCases(Integer pageNumber, Integer pageSize, DecorateType decorateType,
			String searchParam) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pageNumber", pageNumber);
		paramMap.put("pageSize", pageSize);

		if (decorateType != null) {
			paramMap.put("type", decorateType.getValue());
		}
		if (searchParam != null) {
			paramMap.put("searchParam", searchParam.trim());
		}

		Integer total = caseMapper.countCase(paramMap);

		PageInfo<CaseVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		paramMap.put("startIndex", pageInfo.getStartIndex());
		paramMap.put("pageSize", pageInfo.getPageSize());
		List<CaseVo> list = caseMapper.getCases(paramMap);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public CaseVo getCase(String id) {
		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("id", id);

		return caseMapper.getCase(paramMap);
	}

	@Override
	public List<CaseVo> getCases(Integer type) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("limit", 3);
		paramMap.put("type", type);

		return caseMapper.getCasesLimit(paramMap);
	}

	@Override
	public List<CaseVo> getRecommendCases() {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("recommend", 1);

		return caseMapper.getCasesLimit(paramMap);
	}

}