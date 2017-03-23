package com.ujia.lion.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujia.dao.WxAutoReplyMapper;
import com.ujia.lion.service.WxAutoReplyServiceI;
import com.ujia.model.WxAutoReply;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.vo.WxAutoReplyVo;

@Service
public class WxAutoReplyServiceImpl implements WxAutoReplyServiceI {
	
	@Autowired
	private WxAutoReplyMapper autoReplyMapper;

	@Override
	public PageInfo<WxAutoReplyVo> getAutoReplyList(Integer pageIndex, Integer pageSize) {
		


		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageIndex);
		param.put("pageSize", pageSize);

		
		Integer total = autoReplyMapper.getAutoReplyCount(param);

		PageInfo<WxAutoReplyVo> pageInfo = new PageInfo<>(total, pageIndex, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<WxAutoReplyVo> list = autoReplyMapper.getAutoReplyList(param);

		pageInfo.setItems(list);
		return pageInfo;
	
		
		
	}

	@Override
	public WxAutoReply getItemById(String id) {
		return autoReplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public void editItem(WxAutoReply a) {
		
		
		if(a!=null && StringUtils.isNotBlank(a.getId())){//有id为编辑
			autoReplyMapper.updateByPrimaryKeySelective(a);
			
		}else{//添加
			a.setId(SeqFactory.createId());
			a.setCreateTime(new Date());
			autoReplyMapper.insertSelective(a);
		}
		
	}

	@Override
	public void deleteItemById(String id) {
		autoReplyMapper.deleteByPrimaryKey(id);
	}
}