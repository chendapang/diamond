package com.ujia.dao;

import java.util.List;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.WxMenuButton;
import com.ujia.vo.WxMenuButtonVo;

public interface WxMenuButtonMapper extends SqlMapper{
    int deleteByPrimaryKey(String id);

    int insert(WxMenuButton record);

    int insertSelective(WxMenuButton record);

    WxMenuButton selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxMenuButton record);

    int updateByPrimaryKey(WxMenuButton record);

	void clearAll();

	List<WxMenuButtonVo> getMenuList();
}