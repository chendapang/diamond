package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.WxSceneQrcode;

public interface WxSceneQrcodeMapper extends SqlMapper {
    int deleteByPrimaryKey(String id);

    int insert(WxSceneQrcode record);

    int insertSelective(WxSceneQrcode record);

    WxSceneQrcode selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxSceneQrcode record);

    int updateByPrimaryKey(WxSceneQrcode record);

	Integer getWxSceneQrcodeCount(Map<String, Object> param);

	List<WxSceneQrcode> getWxSceneQrcodeList(Map<String, Object> param);
}