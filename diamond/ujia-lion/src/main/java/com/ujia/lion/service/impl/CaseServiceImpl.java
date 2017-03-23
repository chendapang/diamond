package com.ujia.lion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.CaseMapper;
import com.ujia.enums.ActivityStatus;
import com.ujia.enums.DecorateType;
import com.ujia.lion.service.CaseServiceI;
import com.ujia.model.Case;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.vo.CaseVo;

@Service
public class CaseServiceImpl implements CaseServiceI {

	@Autowired
	private CaseMapper caseMapper;

	@Override
	public PageInfo<CaseVo> getItems(ActivityStatus status, Integer pageNumber, Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);

		if (status != null) {
			param.put("status", status.name());
		}

		Integer total = caseMapper.countCase(param);

		PageInfo<CaseVo> pageInfo = new PageInfo<>(total, pageNumber, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<CaseVo> list = caseMapper.getCaseList(param);

		pageInfo.setItems(list);
		return pageInfo;
	}

	@Override
	public CaseVo getItemById(String id) {

		CaseVo a = caseMapper.selectByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteItemById(String id) {
		caseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void editItem(Case a) {

		if (a != null && StringUtils.isNotBlank(a.getId())) {// 有id为编辑

			a.setTypeStr(DecorateType.getDecorateTypeByValue(a.getType()).getComment());
			if (a.getRecommend() == 0) {
				a.setRecommendStr("否");
			} else if (a.getRecommend() == 1) {
				a.setRecommendStr("是");
			}
			
			caseMapper.updateByPrimaryKeySelective(a);

		} else {// 添加
			a.setId(SeqFactory.createId());
			a.setTypeStr(DecorateType.getDecorateTypeByValue(a.getType()).getComment());
			if (a.getRecommend() == 0) {
				a.setRecommendStr("否");
			} else if (a.getRecommend() == 1) {
				a.setRecommendStr("是");
			}
			caseMapper.insertSelective(a);
		}

	}

}