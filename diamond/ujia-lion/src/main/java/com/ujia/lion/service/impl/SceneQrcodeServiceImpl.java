package com.ujia.lion.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.ujia.dao.WxSceneQrcodeMapper;
import com.ujia.lion.service.SceneQrcodeServiceI;
import com.ujia.model.WxSceneQrcode;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.utils.WxUtils;

@Service
public class SceneQrcodeServiceImpl implements SceneQrcodeServiceI {
	
	@Autowired
	private WxSceneQrcodeMapper wxSceneQrcodeMapper;
	

	@Override
	public PageInfo<WxSceneQrcode> getWxSceneQrcodeList(Integer pageIndex, Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("pageNumber", pageIndex);
		param.put("pageSize", pageSize);

		
		Integer total = wxSceneQrcodeMapper.getWxSceneQrcodeCount(param);

		PageInfo<WxSceneQrcode> pageInfo = new PageInfo<>(total, pageIndex, pageSize);
		param.put("startIndex", pageInfo.getStartIndex());
		param.put("pageSize", pageInfo.getPageSize());
		List<WxSceneQrcode> list = wxSceneQrcodeMapper.getWxSceneQrcodeList(param);

		pageInfo.setItems(list);
		return pageInfo;
	}


	@Override
	public WxSceneQrcode getItemById(String id) {
		return wxSceneQrcodeMapper.selectByPrimaryKey(id);
	}


	@Override
	@Transactional
	public void editItem(WxSceneQrcode a) {
		if(a!=null && StringUtils.isNotBlank(a.getId())){//有id为编辑
			
			wxSceneQrcodeMapper.updateByPrimaryKeySelective(a);
		}else{//添加
			a.setId(SeqFactory.createId());
			a.setCreateTime(new Date());
			
			String scene_str = a.getId();
			
			JSONObject jsonObject =WxUtils.createQRcode(scene_str);
			
			System.out.println(jsonObject);
			
			String ticket = jsonObject.getString("ticket");
			String url =  jsonObject.getString("url");
			
			a.setTicket(ticket);
			a.setUrl(url);
			
			wxSceneQrcodeMapper.insertSelective(a);
		}
	}


	


	@Override
	public void deleteItemById(String id) {
		wxSceneQrcodeMapper.deleteByPrimaryKey(id);
	}

}