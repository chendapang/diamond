package com.ujia.virgo.service;

import java.util.List;
import java.util.Map;

import com.ujia.vo.ConstructionVo;

/**
 * 发现服务接口
 * 
 * @author fisher
 *
 */
public interface ConstructionServiceI {

	/**
	 * 获取所有发现工程
	 * 
	 * @return
	 */
	public List<ConstructionVo> constructionList();

	public ConstructionVo getConstructionDetails(String id);

	public Map<String, String> getConstructionAmount();

}