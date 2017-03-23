package com.ujia.dao;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.BannerDetails;

public interface BannerDetailsMapper  extends SqlMapper{
    int deleteByPrimaryKey(String id);

    int insert(BannerDetails record);

    int insertSelective(BannerDetails record);

    BannerDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BannerDetails record);

    int updateByPrimaryKey(BannerDetails record);
}