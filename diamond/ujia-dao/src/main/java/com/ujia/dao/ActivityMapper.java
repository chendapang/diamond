package com.ujia.dao;

import java.util.List;
import java.util.Map;

import com.fisher.mybatis.SqlMapper;
import com.ujia.model.Activity;

public interface ActivityMapper extends SqlMapper{
    int deleteByPrimaryKey(String id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

	List<Activity> getActivityList(Map<String, Object> param);

	Integer getActivityCount(Map<String, Object> param);

}