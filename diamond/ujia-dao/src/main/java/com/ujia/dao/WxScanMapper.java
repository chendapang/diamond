package com.ujia.dao;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.WxScan;

public interface WxScanMapper extends SqlMapper{
    int deleteByPrimaryKey(String id);

    int insert(WxScan record);

    int insertSelective(WxScan record);

    WxScan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxScan record);

    int updateByPrimaryKey(WxScan record);
}