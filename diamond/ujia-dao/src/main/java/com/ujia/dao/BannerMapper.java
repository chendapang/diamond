package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Banner;
import com.ujia.vo.BannerVo;

public interface BannerMapper  extends SqlMapper{
    int deleteByPrimaryKey(String id);

    int insert(Banner record);

    int insertSelective(Banner record);

    BannerVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);
    
    Banner selectByKey(String bannerKey);
    
    public Integer countBanner(Map<String, Object> paramMap);
    
    public List<BannerVo> bannerList(Map<String, Object> paramMap);
    
    BannerVo selectAllByPrimaryKey(String id);
}