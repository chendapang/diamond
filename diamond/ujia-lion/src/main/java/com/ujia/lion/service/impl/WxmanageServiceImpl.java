package com.ujia.lion.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ujia.dao.WxMenuButtonMapper;
import com.ujia.lion.service.WxmanageServiceI;
import com.ujia.utils.PageInfo;
import com.ujia.utils.SeqFactory;
import com.ujia.utils.WxUtils;
import com.ujia.vo.WxMenuButtonVo;

@Service
public class WxmanageServiceImpl implements WxmanageServiceI {
	
	@Autowired
	private WxMenuButtonMapper wxMenuButtonMapper;
	@Override
	public PageInfo<Object> getMaterialList(String tabName, Integer pageIndex, Integer pageSize) {

		JSONObject jsonObject = WxUtils.getMaterialList(tabName, pageIndex, pageSize);

		Integer total = jsonObject.getInteger("total_count");
		PageInfo<Object> pageinfo = new PageInfo<>(total, pageIndex, pageSize);
		List<Object> list = new ArrayList<>();

		JSONArray items = jsonObject.getJSONArray("item");

		
		
		int size = items==null?0:items.size();
		for (int index = 0; index < size; index++) {
			JSONObject object = items.getObject(index, JSONObject.class);
			Map<String, Object> map = new HashMap<>();
			
			String media_id = object.getString("media_id");
			String name = object.getString("name");
			
			map.put("media_id", media_id);
			if(StringUtils.isBlank(name)){
				name = object.getJSONObject("content").getJSONArray("news_item").getObject(0,JSONObject.class).getString("title");
			}
			map.put("name", name);
			
			list.add(map);
		}

		pageinfo.setItems(list);
		return pageinfo;
	}

	@Override
	public List<WxMenuButtonVo> getMenuList() {
		return wxMenuButtonMapper.getMenuList();
	}

	@Override
	@Transactional
	public void saveMenu(List<WxMenuButtonVo> buttons) {
		wxMenuButtonMapper.clearAll();
		
		Iterator<WxMenuButtonVo> buttons_iterator = buttons.iterator();
		
		
		while (buttons_iterator.hasNext()) {
			WxMenuButtonVo wxMenuButtonVo = buttons_iterator.next();
			String createId = SeqFactory.createId();
			wxMenuButtonVo.setId(createId);
			wxMenuButtonMapper.insertSelective(wxMenuButtonVo);
			List<WxMenuButtonVo> sub_button = wxMenuButtonVo.getSub_button();
			
			Iterator<WxMenuButtonVo> iterator = sub_button.iterator();
			
			while(iterator.hasNext()){
				WxMenuButtonVo sub = iterator.next();
				if(StringUtils.isBlank(sub.getName())){
					iterator.remove();
					continue;
				}
				sub.setId(SeqFactory.createId());
				sub.setParentId(createId);
				wxMenuButtonMapper.insertSelective(sub);
				
			}
			
		}
		

		JSONObject jsonObject = WxUtils.createMenu(buttons);
		
		System.out.println("jsonObject="+jsonObject);
		if(jsonObject!=null && jsonObject.getInteger("errcode") == 0){
			
			
		}else{
			throw new RuntimeException("写入菜单报错");
		}
	}

}